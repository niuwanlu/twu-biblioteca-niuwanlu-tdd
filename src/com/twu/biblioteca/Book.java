package com.twu.biblioteca;

/**
 * Created by wlniu on 4/12/15.
 */
public class Book {

    private String name;
    private String author;
    private String yearPublished;
    private boolean checkOut;

    public Book() {
    }

    public Book(String name, String author, String yearPublished, boolean checkOut) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkOut = checkOut;
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

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }


    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }


}
