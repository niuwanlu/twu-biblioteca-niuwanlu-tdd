package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void testCheckoutMovie() {
        String input = "5\n1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        MovieList movieList = new MovieList();
        movieList.initMovieList();
        BibliotecaApp app = Mockito.spy(new BibliotecaApp(movieList));
        app.processUserInput();
        verify(app).checkOutMovie();
        assertEquals(1, app.getMovieList().getAmountOfMovies() - app.getMovieList().getAmountOfAvailableMovies());
    }

    @Test
    public void testWhoCheckedOutABook() throws Exception {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = Mockito.spy(new BookList());
        bookList.initBorrowedBookList();
        BibliotecaApp app = Mockito.spy(new BibliotecaApp(bookList));
        app.checkBookBorrower();
        verify(bookList).getBookBorrower(0);
        assertEquals("Mousse", bookList.getBookBorrower(0));
    }
}