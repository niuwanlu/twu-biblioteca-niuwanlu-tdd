package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;

/**
 * Created by wlniu on 02/07/15.
 */
public class BookListService {


    public BookListService() {
    }


    public ArrayList<Book> getBookList() {
        return initBookList();
    }

        public ArrayList<Book> initBookList() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("Harry Potter", "J.K.Rowling", "1997", true);
        book1.setBookNumber(books.size()+1);
        books.add(book1);
        Book book2 = new Book("A Song of Ice and Fire", "George R. R. Martin", "1996", true);
        book2.setBookNumber(books.size()+1);
        books.add(book2);
        return books;
    }
}
