package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaApp {

    private ArrayList<Book> bookList;

    public void start() {
        showWelcome();
        initBookList();
        showBookList();
    }

    private void initBookList() {
        bookList = new ArrayList<Book>();
        Book book1 = new Book("Harry Potter");
        bookList.add(book1);
        Book book2 = new Book("The Song of Ice and Fire");
        bookList.add(book2);
    }

    public void showWelcome() {
        System.out.println("Welcome to Bivlioteca!");
    }

    public void showBookList() {
        for (Book book : bookList) {
            System.out.println(book.getName());
        }
    }
}
