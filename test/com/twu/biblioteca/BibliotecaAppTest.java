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

//    @Test
//    public void testShowBookList() {
//        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
//        app.start();
//        verify(app, times(1)).showBookList();
//    }
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
}