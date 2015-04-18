package com.twu.biblioteca;

/**
 * Created by wlniu on 4/18/15.
 */
public class Book {

    private String name;
    private String author;
    private String publishYear;

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, String author, String publishYear) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
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

}
