package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by wlniu on 01/07/15.
 */
@Controller
public class BookListController {

    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public String login(Model model) {
        ArrayList<Book> books = initBookList();
        model.addAttribute("books", books);
        model.addAttribute("hello", "hello my dear");
        return "bookList";
    }

    public ArrayList<Book> initBookList() {
        ArrayList<Book> books = new ArrayList<Book>();
        Book book1 = new Book("Harry Potter", "J.K.Rowling", "1997", true);
        book1.setBookNumber(books.size()+1);
        books.add(book1);
        Book book2 = new Book("A Song of Ice and Fire", "George R. R. Martin", "1996", true);
        book2.setBookNumber(books.size()+1);
        books.add(book2);
        return books;
    }
}
