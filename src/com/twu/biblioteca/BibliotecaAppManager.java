package com.twu.biblioteca;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaAppManager {

    public static void main(String[] args) {
        appRun();

        checkBorrower();

        login();
    }

    private static void appRun() {
        BookList bookList = new BookList();
        bookList.initBookList();
        MovieList movieList = new MovieList();
        movieList.initMovieList();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookList, movieList);
        bibliotecaApp.start();
    }

    private static void checkBorrower() {
        BookList bookList = new BookList();
        bookList.initBorrowedBookList();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookList);
        bibliotecaApp.checkBookBorrower();
    }

    private static void login() {
        UserList userList = new UserList();
        userList.initUserList();
        BibliotecaApp app = new BibliotecaApp(userList);
        app.userLogin();
    }
}
