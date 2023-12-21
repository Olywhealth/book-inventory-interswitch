package com.johnson.interswitch.controller;

import com.johnson.interswitch.model.Book;
import com.johnson.interswitch.payload.request.BookRequest;
import com.johnson.interswitch.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/book")
@Api(tags = "Book API")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;


    @ApiOperation(value = "Add book to store", notes = "Add book", response = Book.class)
    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Book> createNewBook(@Valid @RequestBody BookRequest bookDto) {
        Book newBook = bookService.addBook(bookDto);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Add book to store", notes = "Add book", response = Book.class)
    @GetMapping(value = "/{bookId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Book> getBookById(@PathVariable Long bookId) {
        log.info("==== REST TEMPLATE CALL =====");
        Book existing = bookService.getUniqueBook(bookId);
        return new ResponseEntity<>(existing, HttpStatus.OK);
    }

    @ApiOperation(value = "Search for books based on title, author, genre, and publication year",
            notes = "Returns a list of books matching the provided criteria.",
            response = Book.class, responseContainer = "List")
    @GetMapping(value = "/searchBooks", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Book>> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String publicationYear


    ) {
        List<Book> searchResult = bookService.searchForBooks(title, author, genre, publicationYear);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }




}
