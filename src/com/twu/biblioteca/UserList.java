package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wlniu on 4/18/15.
 */
public class UserList {

    ArrayList<User> users = new ArrayList<User>();

    public void initUserList() {
        User user1 = new User("000-0001", "123456");
        users.add(user1);
        User user2 = new User("000-0002", "654321");
        users.add(user2);
    }

    public int isUserExist(String userNumber) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserNumber().equals(userNumber)) {
                return i;
            }
        }
        return -1;
    }

    public boolean userLogin() {
        Scanner scanner = new Scanner(System.in);
        String exceptedPassword = getInputUserNumber(scanner);
        return validatePassword(scanner, exceptedPassword);
    }

    private boolean validatePassword(Scanner scanner, String exceptedPassword) {
        for (int times = 0; times < 3; times++) {
            if (scanner.nextLine().equals(exceptedPassword)) {
                return true;
            } else {
                if (times < 2) {
                    System.out.println("Invalidate password. Please try again.");
                }
            }
        }
        System.out.println("You have tried three times. Please try later.");
        return false;
    }

    private String getInputUserNumber(Scanner scanner) {
        System.out.println("Please input user number:");
        int userIndex = -1;
        while (scanner.hasNextLine())
        {
            userIndex = isUserExist(scanner.nextLine());
            if (userIndex == -1) {
                System.out.println("User does not exist. Please input valid user number:");
            } else {
                System.out.println("Please input password:");
                break;
            }
        }
        return users.get(userIndex).getPassword();
    }

}
