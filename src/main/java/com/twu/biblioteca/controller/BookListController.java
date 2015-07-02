package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.service.BookListService;
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

    private BookListService bookListService;

    public BookListController() {
        this.bookListService = new BookListService();
    }

    public BookListController(BookListService bookListService) {
        this.bookListService = bookListService;
    }

    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public String login(Model model) {
        ArrayList<Book> books = bookListService.getBookList();
        model.addAttribute("books", books);
        return "bookList";
    }

}
