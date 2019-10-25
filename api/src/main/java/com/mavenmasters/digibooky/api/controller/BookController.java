package com.mavenmasters.digibooky.api.controller;

import com.mavenmasters.digibooky.service.BookService;
import com.mavenmasters.digibooky.service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/digibooky/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Map<UUID, BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }
}
