package com.twu.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wlniu on 01/07/15.
 */
@Controller
public class BookListController {

    @RequestMapping(value = "/bookList", method = RequestMethod.GET)
    public String login(Model model) {
        return "loginSuccessful";
    }
}
