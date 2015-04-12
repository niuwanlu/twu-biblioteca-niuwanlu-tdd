package com.twu.biblioteca;

public class BibliotecaApp {

    private String[] books;

    public void setBooks(String[] books) {
        this.books = books;
    }

    public String[] getBooks() {
        return books;
    }

    public static void main(String[] args) {
        showWelcome();
        BibliotecaAppUser.createApp();
    }

    public static void showWelcome() {
        System.out.println("Welcome!");
        System.out.println("=======================");
    }

    public void printBookList() {
        String[] books = getBooks();
        System.out.println("=======Book List=======");
        for (String book : books ) {
            System.out.println(book);
        }
    }

}
