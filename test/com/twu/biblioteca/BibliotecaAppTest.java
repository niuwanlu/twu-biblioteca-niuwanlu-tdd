package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;


public class BibliotecaAppTest {

    @Test
    public void testShowWelcome() {
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        User user = Mockito.mock(User.class);
        app.start(user);
        verify(app, times(1)).showWelcome();
    }

    @Test
    public void testShowMainMenu() {
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        User user = Mockito.mock(User.class);
        app.start(user);
        verify(app).showMainMenu();
    }

    @Test
    public void testShowItemList() {
        ItemList<Book> bookList = new ItemList<Book>();
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = Mockito.mock(Book.class);
        books.add(book1);
        Book book2 = Mockito.mock(Book.class);
        books.add(book2);
        bookList.setItems(books);
        doReturn(true).when(book1).isAvailable();
        doReturn(true).when(book2).isAvailable();
        bookList.showItemList();
        verify(book1, times(1)).printInfo();
        verify(book2, times(1)).printInfo();
    }
//
//    @Test
//    public void testInvalidMenuOptionCalled() {
//        String input = "9";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
//        app.start();
//        verify(app).invalidOption();
//    }
//
//    @Test
//    public void testContinueChooseOption() {
//        String input = "1\n1";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        BookList bookList = Mockito.mock(BookList.class);
//        BibliotecaApp app = new BibliotecaApp(bookList);
//        app.processUserInput();
//        verify(bookList, times(2)).showBookList();
//    }
//
//    @Test
//    public void testQuitWhenChooseTheOption() {
//        String input = "6\n1";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        BookList bookList = Mockito.mock(BookList.class);
//        BibliotecaApp app = Mockito.spy(new BibliotecaApp(bookList));
//        app.processUserInput();
//        verify(app).quitApp();
//        verify(bookList, never()).showBookList();
//    }

    @Test
    public void testSuccessfulCheckOutItem() {
        ItemList<Book> bookList = new ItemList<Book>();
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter", "J.K.Rowling", "1997", true);
        books.add(book);
        bookList.setItems(books);
        User user = Mockito.mock(User.class);
        bookList.successfulCheckOutItem("Book", 1, user);
        assertEquals(false, book.isAvailable());
    }

//    @Test
//    public void testUnsuccessfulCheckOut() {
//        String input = "2\n3";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        BookList bookList = Mockito.mock(BookList.class);
//        BibliotecaApp app = Mockito.spy(new BibliotecaApp(bookList));
//        app.start();
//        verify(app).unsuccessfulCheckOutBook();
//    }
//
//    @Test
//    public void testReturnBook() {
//        String input = "2\n1\n0\n3\n1\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        BookList bookList = new BookList();
//        bookList.initBookList();
//        BibliotecaApp app = Mockito.spy(new BibliotecaApp(bookList));
//        app.start();
//        verify(app).returnBook();
//        assertEquals(0, app.getBookList().getAmountOfBooks() - app.getBookList().getAmountOfAvailableBooks());
//    }

    @Test
    public void testSuccessfulReturnBook() {
        ItemList<Book> bookList = new ItemList<Book>();
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter", "J.K.Rowling", "1997", false);
        books.add(book);
        bookList.setItems(books);
        bookList.successfulReturnItem("Book", 1);
        assertEquals(true, book.isAvailable());
    }
//
//    @Test
//    public void testUnsuccessfulReturnBook() throws Exception {
//        String input = "2\n1\n0\n3\n2\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        BookList bookList = Mockito.mock(BookList.class);
//        BibliotecaApp app = Mockito.spy(new BibliotecaApp(bookList));
//        app.start();
//        verify(app).unsuccessfulReturnBook();
//    }

    @Test
    public void testGetItemType() {
        ItemList<Book> bookList = new ItemList<Book>();
        ArrayList<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter", "J.K.Rowling", "1997", true);
        books.add(book);
        bookList.setItems(books);
        assertEquals("Book", bookList.getItemType());
    }
}