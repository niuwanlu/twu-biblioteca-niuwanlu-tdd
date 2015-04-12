package com.twu.biblioteca;

/**
 * Created by wlniu on 4/12/15.
 */
public class BibliotecaAppManager {

    public static void main(String[] args) {
        BibliotecaAppManager manager = new BibliotecaAppManager();
        manager.createApp();
    }

    public void createApp() {
        BibliotecaApp app = new BibliotecaApp();
        app.showWelcome();
        app.showOptions();
        Book book1 = new Book("Harry Potter", "J.K.Rolling", "2000");
        Book book2 = new Book("Head First Java", "Kathy Sierra", "2007");
        Book[] bookList = {book1, book2};
        app.setBooks(bookList);
        app.printBookList();
    }

}
