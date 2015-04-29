package com.twu.biblioteca;

import com.twu.biblioteca.model.User;

import java.util.ArrayList;

/**
 * Created by wlniu on 4/28/15.
 */
public class UserManager {

    private ArrayList<User> users;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public int getUserIndex(String userNumber) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserNumber().equals(userNumber)) {
                return i;
            }
        }
        return -1;
    }

    public String getExpectedPassword(int index) {
        return users.get(index).getPassword();
    }

    public boolean validatePassword(String expectedPassword, String inputPassword) {
        return expectedPassword.equals(inputPassword);
    }

    public void login() {
        String userInput = "";
        int index = -1;
        while ( index == -1) {
            userInput = InputManager.getInput();
            index = getUserIndex(userInput);
        }
        getExpectedPassword(index);

    }
}
