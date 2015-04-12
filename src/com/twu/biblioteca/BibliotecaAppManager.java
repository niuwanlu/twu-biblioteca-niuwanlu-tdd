package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by wlniu on 4/12/15.
 */
public class BibliotecaAppManager {

    public static void main(String[] args) {
        BibliotecaAppManager manager = new BibliotecaAppManager();
        manager.showWelcome();
        manager.showOptions();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (scanner.next().equals("1")) {
                manager.createApp();
            }
        }
    }

    public void createApp() {
        BibliotecaApp app = new BibliotecaApp();
        Book book1 = new Book("Harry Potter", "J.K.Rolling", "2000");
        Book book2 = new Book("Head First Java", "Kathy Sierra", "2007");
        Book[] bookList = {book1, book2};
        app.setBooks(bookList);
        app.printBookList();
    }

    public void showWelcome() {
        System.out.println("Welcome!");
        System.out.println("=======================");
    }

    public void showOptions() {
        System.out.println("Please choose an option:\n1.List Books");
    }

}
