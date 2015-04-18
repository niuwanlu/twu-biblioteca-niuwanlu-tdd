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

    public void showBookList() {
        System.out.println("======================== Book List ========================");
        for (Book book : books) {
            if (book.getAvailable()) {
                System.out.println("Book Number: " + book.getBookNumber() + "     Book Name: " + book.getName() + "     Author: " + book.getAuthor() + "     Published Year: " + book.getPublishYear());
            }
        }
        System.out.println("===========================================================");
    }

    public void showCheckedOutBookList() {
        System.out.println("===================== Checked Out Book List =====================");
        for (Book book : books) {
            if (!book.getAvailable()) {
                System.out.println("Book Number: " + book.getBookNumber() + "     Book Name: " + book.getName() + "     Author: " + book.getAuthor() + "     Published Year: " + book.getPublishYear());
            }
        }
        System.out.println("=================================================================");
        System.out.println("Please input the book number which you want to return. Input 0 to exit.");
    }
}
