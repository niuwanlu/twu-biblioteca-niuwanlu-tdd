package com.twu.biblioteca;

/**
 * Created by wlniu on 4/18/15.
 */
public class User {

    private String userNumber;
    private String password;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userNumber, String password) {
        this.userNumber = userNumber;
        this.password = password;
    }
}
