package com.twu.biblioteca.model;

public class Book extends Item {

    private String name;
    private String author;
    private String publishYear;
    private int bookNumber;

    public Book() {
    }

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

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public void printInfo() {
        System.out.println("Book Number: " + getBookNumber() + "     Book Name: " + getName() + "     Author: " + getAuthor() + "     Published Year: " + getPublishYear());
    }

}
