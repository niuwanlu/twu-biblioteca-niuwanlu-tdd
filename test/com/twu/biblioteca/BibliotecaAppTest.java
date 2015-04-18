package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


public class BibliotecaAppTest {

    @Test
    public void testShowWelcome() {
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app, times(1)).showWelcome();
    }

    @Test
    public void testShowBookList() throws Exception {
        BibliotecaApp app = Mockito.spy(new BibliotecaApp());
        app.start();
        verify(app, times(1)).showBookList();
    }
}