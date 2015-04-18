package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;


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
    public void testInvalidMenuOptionCalled() throws Exception {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app).invalidOption();
    }
}