package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> books = new ArrayList<Book>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setNumber(books.size()+1);
        books.add(book);
    }

    public void printBookList() {
        System.out.println("=======Book List=======");
        for (Book book : books ) {
            if (!book.isCheckOut()) {
                System.out.print("Book Number: " + book.getNumber() + "  ");
                System.out.print("Book Name: " + book.getName() + "  ");
                System.out.print("Author:  " + book.getAuthor() + "  ");
                System.out.println("Published Year: " + book.getYearPublished());
            }
        }
    }


}
