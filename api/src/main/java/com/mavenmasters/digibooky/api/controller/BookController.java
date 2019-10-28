package com.mavenmasters.digibooky.api.controller;

import com.mavenmasters.digibooky.domain.book.Book;
import com.mavenmasters.digibooky.service.BookService;
import com.mavenmasters.digibooky.service.dto.BookDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(BookController.DIGIBOOKY_CONTROLLER_RESOURCE_URL)
public class BookController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    public static final String DIGIBOOKY_CONTROLLER_RESOURCE_URL = "/books";
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //TODO @PreAuthorize(ROLE_MEMBER)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    //TODO @PreAuthorize(ROLE_LIBRARIAN)
    @PostMapping(path = "/add", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    //TODO @PreAuthorize(ROLE_LIBRARIAN)
    @PostMapping(path = "/delete", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookDto deleteBook(@RequestBody UUID id) {
        return bookService.deleteBook(id);
    }

    //TODO @PreAuthorize(ROLE_LIBRARIAN)
    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookDto updateBook(@PathVariable UUID id, @RequestBody Book book) {
        BookDto bookDtoById = bookService.getDetailsOfBook(id);
        bookDtoById.setTitle(book.getTitle());
        bookDtoById.setSummary(book.getSummary());
        bookDtoById.setAuthor(book.getAuthor());
        return bookService.updateBook(book);
    }

    //TODO @PreAuthorize(ROLE_MEMBER)
    @GetMapping(path = "/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getDetailsOfBook(@PathVariable UUID uuid) {
        return bookService.getDetailsOfBook(uuid);
    }

    //TODO @PreAuthorize(ROLE_MEMBER)
    @GetMapping(path = "/TITLE/")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByTitle(String title) {
        return bookService.getBookByTitle(title);
    }

    //TODO @PreAuthorize(ROLE_MEMBER)
    @GetMapping(path = "/ISBN/")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByISBN(String isbn) {
        return bookService.getBookByISBN(isbn);
    }

    //TODO @PreAuthorize(ROLE_MEMBER)
    @GetMapping(path = "/AUTHOR/")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookByAuthor(String name) {
        return bookService.getBookByAuthor(name);
    }
}
