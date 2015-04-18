package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;


public class BibliotecaAppTest {

    @Test
    public void testShowWelcome() {
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app, times(1)).showWelcome();
    }

    // TODO test show book details

    @Test
    public void testShowMainMenu() {
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).showMainMenu();
    }

    @Test
    public void testListBooksWhenChooseTheOption() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).showBookList();
    }

    @Test
    public void testInvalidMenuOptionCalled() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).invalidOption();
    }

    @Test
    public void testContinueChooseOption() {
        String input = "1\n1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app, times(2)).showBookList();
    }

    @Test
    public void testQuitWhenChooseTheOption() {
        String input = "4\n1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).quitApp();
        verify(app, never()).showBookList();
    }

    @Test
    public void testCheckOutBook() {
        String input = "2\n1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).checkOutBook();
        assertEquals(1, app.getBookList().getAmountOfBooks() - app.getBookList().getAmountOfAvailableBooks());
    }

    @Test
    public void testSuccessfulCheckOut() {
        String input = "2\n1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).successfulCheckOut(1);
    }

    @Test
    public void testUnsuccessfulCheckOut() {
        String input = "2\n3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).unsuccessfulCheckOut();
    }

    @Test
    public void testReturnBook() {
        String input = "2\n1\n0\n3\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).returnBook();
        assertEquals(0, app.getBookList().getAmountOfBooks() - app.getBookList().getAmountOfAvailableBooks());
    }

    @Test
    public void testSuccessfulReturnBook() {
        String input = "2\n1\n0\n3\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).successfulReturnBook(1);
    }
}