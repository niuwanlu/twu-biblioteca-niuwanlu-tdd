package com.twu.biblioteca;

/**
 * Created by wlniu on 4/18/15.
 */
public class Book {

    private static int totalNumber = 0;

    private String name;
    private String author;
    private String publishYear;
    private boolean available;
    private int bookNumber;
    private String borrower;

    public Book(String name, String author, String publishYear, boolean available) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.available = available;
    }

    public Book(String name, String author, String publishYear, boolean available, String borrower) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.available = available;
        this.borrower = borrower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }


    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
}
