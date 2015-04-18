package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by wlniu on 4/18/15.
 */
public class BookList {

    private ArrayList<Book> books;

    public void initBookList() {
        books = new ArrayList<Book>();
        Book book1 = new Book("Harry Potter", "J.K.Rowling", "1997", true);
        books.add(book1);
        Book book2 = new Book("A Song of Ice and Fire", "George R. R. Martin", "1996", true);
        books.add(book2);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public int getAmountOfBooks() {
        return books.size();
    }

    public int getAmountOfAvailableBooks() {
        int count = 0;
        for (Book book : books) {
            if (book.getAvailable()) {
                count++;
            }
        }
        return count;
    }
}
