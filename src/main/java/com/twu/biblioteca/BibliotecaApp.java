package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.User;

import java.util.Scanner;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaApp {

    private ItemList<Book> bookList;
    private ItemList<Movie> movieList;
    private UserList userList;
    private User currentUser;
    private final Scanner scanner = new Scanner(System.in);

    public BibliotecaApp() {
    }

    public BibliotecaApp(UserList userList) {
        this.userList = userList;
    }

    public BibliotecaApp(ItemList<Book> bookList, ItemList<Movie> movieList) {
        this.bookList = bookList;
        this.movieList = movieList;
    }

    public ItemList<Book> getBookList() {
        return bookList;
    }

    public ItemList<Movie> getMovieList() {
        return movieList;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setBookList(ItemList<Book> bookList) {
        this.bookList = bookList;
    }

    public void start(User user) {
        currentUser = user;
        showWelcome();
        showMainMenu();
        processUserInput();
    }

    public void processUserInput() {
        while (scanner.hasNextLine()) {
            String option = scanner.nextLine();
            if (option.equals(Constants.LIST_BOOKS)) {
                bookList.showItemList();
                showMainMenu();
            } else if (option.equals(Constants.CHECK_OUT_BOOKS)) {
                bookList.checkOutItem(currentUser);
                showMainMenu();
            } else if (option.equals(Constants.RETURN_BOOKS)) {
                bookList.returnItem();
                showMainMenu();
            } else if (option.equals(Constants.LIST_MOVIES)) {
                movieList.showItemList();
                showMainMenu();
            } else if (option.equals(Constants.CHECK_OUT_MOVIES)) {
                movieList.checkOutItem(currentUser);
                showMainMenu();
            } else if (option.equals(Constants.RETURN_MOVIES)) {
                movieList.returnItem();
                showMainMenu();
            } else if (option.equals(Constants.QUIT)) {
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
        System.out.println("Please choose an option:\n1.List Books\n2.Check Out Books\n3.Return Books\n4.List Movies\n5.Check Out Movies\n6.Return Movie\n7.Quit\n");
    }

    public void quitApp() {
        System.out.println("Quit! Bye");
    }

    public void checkBookBorrower() {
        bookList.showCheckedOutList();
        System.out.println("Please input the book number you want to check. Input 0 to exit.");
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                break;
            } else if (number > 0 && number <= bookList.getItems().size()) {
                String bookBorrower = bookList.getBookBorrower(number - 1);
                System.out.println(bookBorrower + " has checked out this book.");
            } else {
                System.out.println("The book number is invalidated.");
            }
        }
    }

    public User userLogin() {
        User user;
        do {
            user = userList.userLogin();
        } while (user == null);
        System.out.println("Log in successfully.");
        user.printUserInformation();
        return user;
    }


}
