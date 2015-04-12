package com.twu.biblioteca;

/**
 * Created by wlniu on 4/12/15.
 */
public class Book {

    private static int total = 0;

    private int number;
    private String name;
    private String author;
    private String yearPublished;
    private boolean checkOut;

    public Book() {
        total++;
        this.number = total;
    }

    public Book(String name, String author, String yearPublished, boolean checkOut) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkOut = checkOut;
        total++;
        this.number = total;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Book.total = total;
    }
}
