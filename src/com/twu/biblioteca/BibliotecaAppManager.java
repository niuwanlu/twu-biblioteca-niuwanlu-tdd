package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaAppManager {

    public static void main(String[] args) {
        ItemList<Book> bookList = new ItemList<Book>();
        initBookList(bookList);
        ItemList<Movie> movieList = new ItemList<Movie>();
        initMovieList(movieList);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(bookList, movieList);
        login(bibliotecaApp);
        checkBorrower(bibliotecaApp);
    }

    private static void checkBorrower(BibliotecaApp bibliotecaApp) {
        bibliotecaApp.checkBookBorrower();
    }

    private static void login(BibliotecaApp bibliotecaApp) {
        UserList userList = new UserList();
        userList.initUserList();
        BibliotecaApp app = new BibliotecaApp(userList);
        User user = app.userLogin();
        bibliotecaApp.start(user);
    }

    private static void initBookList(ItemList<Book> bookList) {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("Harry Potter", "J.K.Rowling", "1997", true);
        book1.setBookNumber(books.size()+1);
        books.add(book1);
        Book book2 = new Book("A Song of Ice and Fire", "George R. R. Martin", "1996", true);
        book2.setBookNumber(books.size()+1);
        books.add(book2);
        bookList.setItems(books);
    }

    private static void initMovieList(ItemList<Movie> movieList) {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Movie movie1 = new Movie("Gone with the Wind", "1939", "Victor Fleming", 8, true);
        movies.add(movie1);
        Movie movie2 = new Movie("Roman Holiday", "1953", "William Wyler", 9, true);
        movies.add(movie2);
        movieList.setItems(movies);
    }

//    public static void initBorrowedBookList(ItemList<Book> bookList) {
//        ArrayList<Book> books = new ArrayList<Book>();
//        Book book1 = new Book("Harry Potter", "J.K.Rowling", "1997", false, "000-0001");
//        book1.setBookNumber(books.size()+1);
//        books.add(book1);
//        Book book2 = new Book("A Song of Ice and Fire", "George R. R. Martin", "1996", false, "000-0002");
//        book2.setBookNumber(books.size()+1);
//        books.add(book2);
//        bookList.setItems(books);
//    }
}
