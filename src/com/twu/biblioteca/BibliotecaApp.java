package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by wlniu on 4/17/15.
 */
public class BibliotecaApp {

    private ItemList<Book> bookList;
    private ItemList<Movie> movieList;
    private UserList userList;
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

    public void start() {
        showWelcome();
        showMainMenu();
        processUserInput();
    }

    public void processUserInput() {
        while (scanner.hasNextLine()) {
            String option = scanner.nextLine();
            if (option.equals(Constants.LIST_BOOKS)) {
                bookList.showItemList("Book");
                showMainMenu();
            } else if (option.equals(Constants.CHECK_OUT_BOOKS)) {
                checkOutItem(bookList, "Book");
                showMainMenu();
            } else if (option.equals(Constants.RETURN_BOOKS)) {
                returnItem(bookList, "Book");
                showMainMenu();
            } else if (option.equals(Constants.LIST_MOVIES)) {
                movieList.showItemList("Movie");
                showMainMenu();
            } else if (option.equals(Constants.CHECK_OUT_MOVIES)) {
                checkOutItem(movieList, "Movie");
                showMainMenu();
            } else if (option.equals(Constants.RETURN_MOVIES)) {
                returnItem(movieList, "Movie");
                showMainMenu();
            } else if (option.equals(Constants.QUIT)) {
                quitApp();
                break;
            } else {
                invalidOption();
            }
        }
    }

    private void checkOutItem(ItemList itemList, String itemType) {
        showItemListWithCheckOutNote(itemList, itemType);
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                return;
            } else if (number > 0 && number <= itemList.getAmountOfItems() && itemList.isItemAvailable(number)) {
                successfulCheckOutItem(itemList, itemType, number);
            } else {
                unsuccessfulCheckOutItem(itemList, itemType);
            }
        }
    }

    private void showItemListWithCheckOutNote(ItemList itemList, String itemType) {
        itemList.showItemList(itemType);
        System.out.println("Please choose the " + itemType + " number which you want to check out. Input 0 to exit.");
    }

    public void successfulCheckOutItem(ItemList itemList, String itemType, int number) {
        itemList.setItemAvailable(number,false);
        System.out.println("Thank you! Enjoy the " + itemType + ".");
        showItemListWithCheckOutNote(itemList, itemType);
    }

    public void unsuccessfulCheckOutItem(ItemList itemList, String itemType) {
        System.out.println("That movie is not available. Please check out other b movies.");
        showItemListWithCheckOutNote(itemList, itemType);
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

    public void returnItem(ItemList itemList, String itemType) {
        itemList.showCheckedOutListWithPrompt(itemType);
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                return;
            } else if (number > 0 && number <= itemList.getAmountOfItems() && !itemList.isItemAvailable(number)) {
                successfulReturnItem(itemList,itemType, number);
            } else {
                unsuccessfulReturnItem(itemList, itemType);
            }
        }
    }

    public void successfulReturnItem(ItemList itemList, String itemType, int number) {
        itemList.setItemAvailable(number, true);
        System.out.println("Thank you for returning " + itemType + ".");
        itemList.showCheckedOutListWithPrompt(itemType);
    }

    public void unsuccessfulReturnItem(ItemList itemList, String itemType) {
        System.out.println("That " + itemType + " is not a valid " + itemType + " to return.");
        itemList.showCheckedOutListWithPrompt(itemType);
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

    public void userLogin() {
        User user;
        do {
            user = userList.userLogin();
        } while (user == null);
        System.out.println("Log in successfully.");
        user.printUserInformation();
    }


}
