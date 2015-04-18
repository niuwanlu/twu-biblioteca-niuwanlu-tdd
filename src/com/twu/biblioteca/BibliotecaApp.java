package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaApp {

    private ArrayList<Book> bookList;

    public void start() {
        showWelcome();
        initBookList();
        showMainMenu();
        processUserInput();
    }

    private void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String option = scanner.nextLine();
            if (option.equals("1")) {
                showBookList();
            } else {
                invalidOption();
            }
        }
    }

    public void invalidOption() {
        System.out.println("This option is invalid, please select a valid option!");
    }

    private void initBookList() {
        bookList = new ArrayList<Book>();
        Book book1 = new Book("Harry Potter", "J.K.Rowling", "1997");
        bookList.add(book1);
        Book book2 = new Book("A Song of Ice and Fire", "George R. R. Martin", "1996");
        bookList.add(book2);
    }

    public void showWelcome() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println();
    }

    public void showBookList() {
        System.out.println("======================== Book List ========================");
        for (Book book : bookList) {
            System.out.println("Book Name: " + book.getName() + "     Author: " + book.getAuthor() + "     Published Year: " + book.getPublishYear());
        }
        System.out.println("===========================================================");
    }

    public void showMainMenu() {
        System.out.println("Please choose an option:\n1.List Books\n2.Check Out Books\n3.Return Books\n4.Quit\n");
    }
}
