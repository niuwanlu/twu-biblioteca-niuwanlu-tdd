package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface BookListService {

    ArrayList<Book> getBookList();

}
