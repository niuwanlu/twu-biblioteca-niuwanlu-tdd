package com.twu.biblioteca;

/**
 * Created by wlniu on 4/12/15.
 */
public class BibliotecaAppUser {

    public static void createApp() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        Book book1 = new Book("Harry Potter", "J.K.Rolling", "2000");
        Book book2 = new Book("Head First Java", "Kathy Sierra", "2007");
        Book[] bookList = {book1, book2};
        biblioteca.setBooks(bookList);
        biblioteca.printBookList();
    }

}
