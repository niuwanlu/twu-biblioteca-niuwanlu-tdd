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
        BibliotecaApp app = new BibliotecaApp();
        Book book1 = new Book("Harry Potter", "J.K.Rolling", "2000", false);
        Book book2 = new Book("Head First Java", "Kathy Sierra", "2007", false);
        Book[] bookList = {book1, book2};
        app.setBooks(bookList);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String optoin = scanner.nextLine();
            if (optoin.equals("1")) {
                app.printBookList();
            } else if (optoin.equals("2")) {
                checkOutBook(manager, app, bookList, scanner);
                continue;
            } else if (optoin.equals("3")) {
                System.out.println("Quit!");
                break;
            } else {
                System.out.println("Select a valid option!");
            }
        }
    }

    private static void checkOutBook(BibliotecaAppManager manager, BibliotecaApp app, Book[] bookList, Scanner scanner) {
        app.printBookList();
        System.out.println("Please choose the book you want to check out. Input 0 to cancel.");
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                manager.showOptions();
                return;
            } else if (number < 0 || number > Book.getTotal()) {
                System.out.println("That book is not available! Please recheck.");
            } else {
                bookList[number - 1].setCheckOut(true);
                app.setBooks(bookList);
                System.out.println("Thank you! Enjoy the book.");
            }
        }
    }

    public void showWelcome() {
        System.out.println("Welcome!");
        System.out.println("=======================");
    }

    public void showOptions() {
        System.out.println("Please choose an option:\n1.List Books\n2.Check Out Books\n3.Quit");
    }

}
