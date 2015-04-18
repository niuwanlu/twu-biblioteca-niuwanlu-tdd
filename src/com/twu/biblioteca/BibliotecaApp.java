package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaApp {

    private BookList bookList;
    private MovieList movieList;
    private final Scanner scanner = new Scanner(System.in);

    public BibliotecaApp() {
    }

    public BibliotecaApp(BookList bookList) {
        this.bookList = bookList;
    }

    public BibliotecaApp(MovieList movieList) {
        this.movieList = movieList;
    }

    public BibliotecaApp(BookList bookList, MovieList movieList) {
        this.bookList = bookList;
        this.movieList = movieList;
    }

    public BookList getBookList() {
        return bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }

    public void start() {
        showWelcome();
        showMainMenu();
        processUserInput();
    }

    public void processUserInput() {
        while (scanner.hasNextLine()) {
            String option = scanner.nextLine();
            if (option.equals("1")) {
                bookList.showBookList();
                showMainMenu();
            } else if (option.equals("2")) {
                checkOutBook();
                showMainMenu();
            } else if (option.equals("3")) {
                returnBook();
                showMainMenu();
            } else if (option.equals("4")) {
                movieList.showMovieList();
                showMainMenu();
            } else if (option.equals("5")) {
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

    public void showMainMenu() {
        System.out.println("Please choose an option:\n1.List Books\n2.Check Out Books\n3.Return Books\n4.List Movies\n5.Quit\n");
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
        bookList.showBookList();
        System.out.println("Please choose the book number which you want to check out. Input 0 to exit.");
    }

    public void unsuccessfulCheckOut() {
        System.out.println("That book is not available. Please check out other books.");
        showBookListWithCheckOutNote();
    }

    public void returnBook() {
        bookList.showCheckedOutBookList();
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

    public void unsuccessfulReturnBook() {
        System.out.println("That book is not a valid book to return.");
        bookList.showCheckedOutBookList();
    }

    public void successfulReturnBook(int number) {
        bookList.getBooks().get(number-1).setAvailable(true);
        System.out.println("Thank you for returning book.");
        bookList.showCheckedOutBookList();
    }
}
