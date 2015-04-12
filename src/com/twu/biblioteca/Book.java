package com.twu.biblioteca;

/**
 * Created by wlniu on 4/12/15.
 */
public class Book {
    private String name;
    private String author;
    private String yearPublished;

    public Book() {
    }

    public Book(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }
}
