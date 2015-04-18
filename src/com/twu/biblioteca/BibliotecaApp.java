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
            } else if (option.equals("3")) {
                returnBook();
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
        showBookListWithCheckOutNote();
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                return;
            } else if (number > 0 && number <= bookList.getAmountOfBooks() && bookList.getBooks().get(number-1).getAvailable()) {
                successfulCheckOut(number);
            } else {
                unsuccessfulCheckOut();
            }
        }
    }

    public void successfulCheckOut(int number) {
        bookList.getBooks().get(number - 1).setAvailable(false);
        System.out.println("Thank you! Enjoy the book.");
        showBookListWithCheckOutNote();
    }

    private void showBookListWithCheckOutNote() {
        showBookList();
        System.out.println("Please choose the book number which you want to check out. Input 0 to exit.");
    }

    public void unsuccessfulCheckOut() {
        System.out.println("That book is not available. Please check out other books.");
        showBookListWithCheckOutNote();
    }

    public void returnBook() {
        showCheckedOutBookList();
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                return;
            } else if (number > 0 && number <= bookList.getAmountOfBooks() && !bookList.getBooks().get(number-1).getAvailable()) {
                successfulReturnBook(number);
            } else {
                unsuccessfulReturnBook();
            }
        }

    }

    private void showCheckedOutBookList() {
        System.out.println("===================== Checked Out Book List =====================");
        for (Book book : bookList.getBooks()) {
            if (!book.getAvailable()) {
                System.out.println("Book Number: " + book.getBookNumber() + "     Book Name: " + book.getName() + "     Author: " + book.getAuthor() + "     Published Year: " + book.getPublishYear());
            }
        }
        System.out.println("=================================================================");
        System.out.println("Please input the book number which you want to return. Input 0 to exit.");
    }

    public void unsuccessfulReturnBook() {
        System.out.println("That book is not a valid book to return.");
        showCheckedOutBookList();
    }

    public void successfulReturnBook(int number) {
        bookList.getBooks().get(number-1).setAvailable(true);
        System.out.println("Thank you for returning book.");
        showCheckedOutBookList();
    }
}
