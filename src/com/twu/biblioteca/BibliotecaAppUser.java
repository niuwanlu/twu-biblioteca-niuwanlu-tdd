package com.twu.biblioteca;

/**
 * Created by wlniu on 4/12/15.
 */
public class BibliotecaAppUser {

    public static void createApp() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        String[] bookList = {"Harry Potter", "Head First Java"};
        biblioteca.setBooks(bookList);
        biblioteca.printBookList();
    }

}
