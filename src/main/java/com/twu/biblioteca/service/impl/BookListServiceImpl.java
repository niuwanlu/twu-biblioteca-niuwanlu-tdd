package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.mapper.BookListMapper;
import com.twu.biblioteca.mapper.MyBatisUtil;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BookListService;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class BookListServiceImpl implements BookListService {

    private SqlSession sqlSession;
    private BookListMapper bookListMapper;

    public BookListServiceImpl() {
        this.sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        this.bookListMapper = sqlSession.getMapper(BookListMapper.class);
    }

    public BookListServiceImpl(BookListMapper bookListMapper) {
        this.bookListMapper = bookListMapper;
    }

    @Override
    public ArrayList<Book> getBookList() {
        return bookListMapper.getBookList();
    }

}
