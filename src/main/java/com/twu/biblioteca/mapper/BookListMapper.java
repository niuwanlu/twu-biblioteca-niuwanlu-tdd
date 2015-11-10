package com.twu.biblioteca.mapper;

import com.twu.biblioteca.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface BookListMapper {

    @Select(
            "SELECT bookname, author, publish_year FROM books"
    )
    @Results(value = {
            @Result(property = "name", column = "bookname"),
            @Result(property = "author", column = "author"),
            @Result(property = "publishYear", column = "publish_year")
    })
    ArrayList<Book> getBookList();


}
