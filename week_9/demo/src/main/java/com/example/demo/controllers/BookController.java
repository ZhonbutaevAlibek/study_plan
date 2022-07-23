package com.example.demo.controllers;

import com.example.demo.entities.BookEntity;
import com.example.demo.repositories.BookRepo;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getAllBooks(Model model){
        model.addAttribute("books", this.bookService.getAll());
        return "books";
    }
}
