package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by wlniu on 4/12/15.
 */
public class BibliotecaAppManager {

    public static void main(String[] args) {
        BibliotecaAppManager manager = new BibliotecaAppManager();
        manager.showWelcome();
        manager.showMainMenu();
        BibliotecaApp app = createBibliotecaApp();
        manager.appRun(app);
    }

    private static BibliotecaApp createBibliotecaApp() {
        BibliotecaApp app = new BibliotecaApp();
        Book book1 = new Book("Harry Potter", "J.K.Rolling", "2000", false);
        app.addBook(book1);
        Book book2 = new Book("Head First Java", "Kathy Sierra", "2007", false);
        app.addBook(book2);
        return app;
    }

    public void appRun(BibliotecaApp app) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String optoin = scanner.nextLine();
            if (optoin.equals("1")) {
                app.printBookList();
            } else if (optoin.equals("2")) {
                checkOutBook(app);
            } else if (optoin.equals("3")) {
                returnBook(app);
            } else if (optoin.equals("4")) {
                System.out.println("Quit!");
                break;
            } else {
                System.out.println("Select a valid option!");
            }
        }
    }

    public void returnBook(BibliotecaApp app) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the book number you want to return. Input 0 to cancel.");
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                showMainMenu();
                return;
            } else if ( (number > 0 && number <= app.getBooks().size()) && app.getBooks().get(number - 1).isCheckOut()) {
                    app.getBooks().get(number - 1).setCheckOut(false);
                    System.out.println("Thank you for return the book.");
            } else {
                System.out.println("That is a invalid book to return.");
            }
        }
    }

    public void checkOutBook(BibliotecaApp app) {
        Scanner scanner = new Scanner(System.in);
        app.printBookList();
        System.out.println("Please choose the book number you want to check out. Input 0 to cancel.");
        while (scanner.hasNextLine()) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 0) {
                showMainMenu();
                return;
            } else if (number < 0 || number > app.getBooks().size()) {
                System.out.println("That book is not available! Please recheck.");
            } else {
                app.getBooks().get(number - 1).setCheckOut(true);
                System.out.println("Thank you! Enjoy the book.");
            }
        }
    }

    public void showWelcome() {
        System.out.println("Welcome!");
        System.out.println("=======================");
    }

    public void showMainMenu() {
        System.out.println("Please choose an option:\n1.List Books\n2.Check Out Books\n3.Return Book\n4.Quit");
    }

}
