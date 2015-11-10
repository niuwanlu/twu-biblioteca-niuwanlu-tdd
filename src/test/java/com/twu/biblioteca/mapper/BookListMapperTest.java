package com.twu.biblioteca.mapper;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class BookListMapperTest extends MapperTestBase {

    private BookListMapper bookListMapper;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        bookListMapper = getSqlSession().getMapper(BookListMapper.class);
    }

    @Test
    public void testGetBookList() throws Exception {
        List<Book> books = bookListMapper.getBookList();
        assertEquals(books.size(), 2);
    }
}