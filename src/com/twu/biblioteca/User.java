package com.twu.biblioteca;

/**
 * Created by wlniu on 4/18/15.
 */
public class User {

    private String userNumber;
    private String password;
    private String userName;
    private String email;
    private String phone;

    public User(String userNumber, String password) {
        this.userNumber = userNumber;
        this.password = password;
    }

    public User(String userNumber, String password, String userName, String email, String phone) {
        this.userNumber = userNumber;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void printUserInformation() {
        System.out.println("Your information:\nUser name: " + userName + "     Email address: " + email + "     Phone number: " + phone);
    }
}
