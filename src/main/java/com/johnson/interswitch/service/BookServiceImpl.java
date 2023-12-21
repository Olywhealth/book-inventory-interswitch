package com.johnson.interswitch.service;

import com.johnson.interswitch.contracts.ExtractRequestResponse;
import com.johnson.interswitch.exception.CustomException;
import com.johnson.interswitch.model.Book;
import com.johnson.interswitch.payload.request.BookRequest;
import com.johnson.interswitch.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * @author Johnson on 16/12/2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final EntityManager entityManager;


    @ExtractRequestResponse
    public Book addBook(BookRequest request) {
        Book book = new Book();
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setIsbn(request.isbn());
        book.setGenre(request.genre());
        book.setPrice(request.price());
        book.setYearOfPublication(request.yearOfPublication());
        return bookRepository.save(book);

    }

    @ExtractRequestResponse
    public Book getUniqueBook(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.orElseThrow(() -> new CustomException("No book with ID " + bookRepository));
    }

    @ExtractRequestResponse
    public List<Book> searchForBooks(String title, String author, String genre, String publicationYear) {
        StringBuilder builder = new StringBuilder()
                .append("select b from Book b where lower(b.title) like CONCAT('%',:title,'%')");

        if (author != null && !author.trim().isEmpty()) {
            builder.append("and lower(b.author) = lower(:author) ");
        }
        if (genre != null && !genre.trim().isEmpty()) {
            builder.append("and lower(b.genre) = lower(:genre) ");
        }
        TypedQuery<Book> query = entityManager.createQuery(builder.toString(), Book.class);

        query.setParameter("title", title);

        if (author != null && !"".equals(author.trim())) {
            query.setParameter("author", author);
        }
        if (genre != null && !"".equals(genre.trim())) {
            query.setParameter("genre", genre);
        }
        return query.getResultList();
    }
}
