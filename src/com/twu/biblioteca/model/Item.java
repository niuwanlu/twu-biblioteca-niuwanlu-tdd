package com.twu.biblioteca.model;

/**
 * Created by wlniu on 4/23/15.
 */
public class Item {

    protected boolean available;
    protected String borrower;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public void printInfo() {
    }
}
