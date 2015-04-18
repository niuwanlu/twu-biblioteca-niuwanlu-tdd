package com.twu.biblioteca;

/**
 * Created by wlniu on 4/18/15.
 */
public class Book {

    private String name;
    private String author;
    private String publishYear;
    private boolean available;
    private int bookNumber;
    private static int totalNumber = 0;

    public Book(String name, String author, String publishYear, boolean available) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.available = available;
        this.bookNumber = (++totalNumber);
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

}
