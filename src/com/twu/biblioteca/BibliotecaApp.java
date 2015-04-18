package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaApp {

    private BookList bookList;
    private final Scanner scanner = new Scanner(System.in);

    public BookList getBookList() {
        return bookList;
    }

    public void start() {
        showWelcome();
        bookList = new BookList();
        bookList.initBookList();
        showMainMenu();
        processUserInput();
    }

    public void processUserInput() {
        while (scanner.hasNextLine()) {
            String option = scanner.nextLine();
            if (option.equals("1")) {
                showBookList();
                showMainMenu();
            } else if (option.equals("2")) {
                checkOutBook();
                showMainMenu();
            } else if (option.equals("4")) {
                quitApp();
                break;
            } else {
                invalidOption();
            }
        }
    }

    public void invalidOption() {
        System.out.println("This option is invalid, please select a valid option!");
    }

    public void showWelcome() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println();
    }

    public void showBookList() {
        System.out.println("======================== Book List ========================");
        for (Book book : bookList.getBooks()) {
            if (book.getAvailable()) {
                System.out.println("Book Number: " + book.getBookNumber() + "     Book Name: " + book.getName() + "     Author: " + book.getAuthor() + "     Published Year: " + book.getPublishYear());
            }
        }
        System.out.println("===========================================================");
    }

    public void showMainMenu() {
        System.out.println("Please choose an option:\n1.List Books\n2.Check Out Books\n3.Return Books\n4.Quit\n");
    }

    public void quitApp() {
        System.out.println("Quit! Bye");
    }

    public void checkOutBook() {
        showBookList();
        System.out.println("Please choose the book number which you want to check out. Input 0 to exit.");
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                return;
            } else {
                bookList.getBooks().get(number-1).setAvailable(false);
                showBookList();
                System.out.println("Please choose the book number which you want to check out. Input 0 to exit.");
            }
        }
    }
}
