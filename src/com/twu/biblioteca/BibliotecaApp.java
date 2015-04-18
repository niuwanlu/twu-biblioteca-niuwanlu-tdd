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
        Book book1 = new Book("Harry Potter", "J.K.Rowling", "1997");
        bookList.add(book1);
        Book book2 = new Book("A Song of Ice and Fire", "George R. R. Martin", "1996");
        bookList.add(book2);
    }

    public void showWelcome() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println();
    }

    public void showBookList() {
        System.out.println("======================== Book List ========================");
        for (Book book : bookList) {
            System.out.println("Book Name: " + book.getName() + "     Author: " + book.getAuthor() + "     Published Year: " + book.getPublishYear());
        }
        System.out.println("===========================================================");
    }
}
