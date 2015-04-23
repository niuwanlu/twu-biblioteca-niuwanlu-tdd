package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

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
        String input = "1\n3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BookList bookList = Mockito.spy(new BookList());
        bookList.initBorrowedBookList();
        BibliotecaApp app = Mockito.spy(new BibliotecaApp(bookList));
        app.checkBookBorrower();
        verify(bookList).getBookBorrower(0);
        assertEquals("000-0001", bookList.getBookBorrower(0));
        verify(bookList, never()).getBookBorrower(2);
    }

    @Test
    public void testUserLoginSuccessful() throws Exception {
        String input = "000-0001\n123456";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserList userList = new UserList();
        userList.initUserList();
        assertEquals(userList.getUsers().get(0), userList.userLogin());
    }

    @Test
    public void testUserLoginUnsuccessful() throws Exception {
        String input = "000-0001\n12345\n325\n356";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserList userList = new UserList();
        userList.initUserList();
        assertEquals(null, userList.userLogin());
    }

    @Test
    public void testUserLoginSuccessfulAndShowInformation() throws Exception {
        String input = "000-0001\n123456";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        User user = Mockito.spy(new User("000-0001", "123456", "Mousse", "mousse@tw.com", "1111111"));
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        UserList userList = new UserList(users);
        BibliotecaApp app = new BibliotecaApp(userList);
        app.userLogin();
        verify(user).printUserInformation();
    }
}