package com.twu.biblioteca.service;

import com.twu.biblioteca.mapper.BookListMapper;
import com.twu.biblioteca.service.impl.BookListServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookListServiceTest {

    private BookListService bookListService;

    @Mock
    BookListMapper bookListMapper;

    @Before
    public void setUp() {
        initMocks(this);
        bookListService = new BookListServiceImpl(bookListMapper);
    }

    @Test
    public void shouldCallBookListMapper() throws Exception {
        bookListService.getBookList();
        verify(bookListMapper).getBookList();
    }

}