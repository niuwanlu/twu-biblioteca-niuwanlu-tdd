package com.twu.biblioteca.controller;

import com.twu.biblioteca.service.BookListService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookListControllerTest {

    private BookListController bookListController;

    @Mock
    private Model model;

    @Mock
    private BookListService bookListService;

    @Before
    public void setUp() {
        initMocks(this);
        bookListController = new BookListController(bookListService);
    }

    @Test
    public void shouldInvokeBookListService() throws Exception {
        bookListController.login(model);
        verify(bookListService).getBookList();
    }
}