package com.twu.biblioteca;

/**
 * Created by wlniu on 4/23/15.
 */
public class Item {

    private boolean available;
    private String borrower;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBorrower() {
        return borrower;
    }

    public void printInfo() {
    }
}
