package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

public class BibliotecaAppReleaseTwoTest {

    @Test
    public void testShowMovieList() {
        String input = "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        MovieList movieList = Mockito.mock(MovieList.class);
        BibliotecaApp app = Mockito.spy(new BibliotecaApp(movieList));
        app.processUserInput();
        verify(movieList).showMovieList();
    }
}