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
        return Constants.NO_EXIST_USER_NUMBER;
    }

    public String getExpectedPassword(int index) {
        return users.get(index).getPassword();
    }

    public boolean validatePassword(String expectedPassword, String inputPassword) {
        return expectedPassword.equals(inputPassword);
    }

    public User login() {
        User loginUser = null;
        while (loginUser == null) {
            loginUser = oneLogin();
        }
        return loginUser;
    }

    public User oneLogin() {
        String userInput = "";
        int index = Constants.NO_EXIST_USER_NUMBER;
        while ( index == Constants.NO_EXIST_USER_NUMBER) {
            userInput = InputManager.getInput();
            index = getUserIndex(userInput);
        }
        String expectedPassword = getExpectedPassword(index);
        for (int inputTimes = 0; inputTimes < Constants.MAX_PASSWORD_INPUT_TIMES; inputTimes++) {
            if (InputManager.getInput().equals(expectedPassword)) {
                return users.get(index);
            }
        }
        return null;
    }
}
