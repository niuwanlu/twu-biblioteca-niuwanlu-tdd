package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wlniu on 4/18/15.
 */
public class UserList {

    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public UserList() {
    }

    public UserList(ArrayList<User> users) {
        this.users = users;
    }

    public void initUserList() {
        users = new ArrayList<User>();
        User user1 = new User("000-0001", "123456", "Mousse", "mousse@tw.com", "1111111");
        users.add(user1);
        User user2 = new User("000-0002", "654321", "Luca", "luca@tw.com", "0000000");
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

    public User userLogin() {
        Scanner scanner = new Scanner(System.in);
        int userIndex = getInputUserNumber(scanner);
        if (validatePassword(scanner, userIndex)) {
            return users.get(userIndex);
        } else {
            return null;
        }
    }

    private boolean validatePassword(Scanner scanner, int userIndex) {
        String exceptedPassword = users.get(userIndex).getPassword();
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

    private int getInputUserNumber(Scanner scanner) {
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
        return userIndex;
    }

}
