package com.twu.biblioteca;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaAppManager {

    public static void main(String[] args) {
        BookList bookList = new BookList();
        bookList.initBookList();
        MovieList movieList = new MovieList();
        movieList.initMovieList();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookList, movieList);
        bibliotecaApp.start();
    }
}
