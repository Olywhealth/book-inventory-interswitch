package com.johnson.interswitch.service;

import com.johnson.interswitch.model.Book;
import com.johnson.interswitch.payload.request.BookRequest;
import com.johnson.interswitch.payload.response.GenericResponse;

import java.util.List;

/**
 * @author Johnson on 16/12/2023
 */
public interface BookService {
    Book addBook(BookRequest request);

    Book getUniqueBook(Long bookId);

    List<Book> searchForBooks(String title, String author, String genre, String publicationYear);
}
