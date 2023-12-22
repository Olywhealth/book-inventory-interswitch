package com.johnson.interswitch.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.johnson.interswitch.enums.Genre;
import com.johnson.interswitch.exception.CustomException;
import com.johnson.interswitch.model.Book;
import com.johnson.interswitch.model.User;
import com.johnson.interswitch.model.UserCart;
import com.johnson.interswitch.payload.request.BookRequest;
import com.johnson.interswitch.repository.BookRepository;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookServiceImplTest {
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @MockBean
    EntityManager entityManager;



    @Test
    void testAddBook() {
        User user = new User();
        user.setCart(new UserCart());
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("johnson@example.org");
        user.setId(1L);
        user.setName("Johnson");
        user.setPhoneNumber("+234567890");
        user.setTransactionHistories(new ArrayList<>());

        UserCart cart = new UserCart();
        cart.setBooks(new ArrayList<>());
        cart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart.setId(1L);
        cart.setUser(user);

        User user2 = new User();
        user2.setCart(cart);
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("johnson@example.org");
        user2.setId(1L);
        user2.setName("Johnson");
        user2.setPhoneNumber("+234567890");
        user2.setTransactionHistories(new ArrayList<>());

        UserCart cart2 = new UserCart();
        cart2.setBooks(new ArrayList<>());
        cart2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart2.setId(1L);
        cart2.setUser(user2);

        Book book = new Book();
        book.setAuthor("Johnson");
        book.setCart(cart2);
        book.setGenre(Genre.FICTION);
        book.setId(1L);
        book.setIsbn("0-13-149505-0");
        book.setPrice(10.0d);
        book.setTitle("Java");
        book.setYearOfPublication("2021");
        when(bookRepository.save(Mockito.<Book>any())).thenReturn(book);
        Book actualAddBookResult = bookServiceImpl
                .addBook(new BookRequest("Java", Genre.FICTION, "0-13-149505-0", "Johnson", "2021", 10.0d));
        verify(bookRepository).save(Mockito.<Book>any());
        assertSame(book, actualAddBookResult);
    }


    @Test
    void testAddBook2() {
        when(bookRepository.save(Mockito.<Book>any())).thenThrow(new CustomException("An error occurred"));
        assertThrows(CustomException.class, () -> bookServiceImpl
                .addBook(new BookRequest("Java", Genre.FICTION, "0-13-149505-0", "Johnson", "1997", 10.0d)));
        verify(bookRepository).save(Mockito.<Book>any());
    }


    @Test
    void testGetUniqueBook() {
        UserCart cart = new UserCart();
        cart.setBooks(new ArrayList<>());
        cart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart.setId(1L);
        cart.setUser(new User());

        User user = new User();
        user.setCart(cart);
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("johnson@example.org");
        user.setId(1L);
        user.setName("Johnson");
        user.setPhoneNumber("+234567890");
        user.setTransactionHistories(new ArrayList<>());

        UserCart cart2 = new UserCart();
        cart2.setBooks(new ArrayList<>());
        cart2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart2.setId(1L);
        cart2.setUser(user);

        Book book = new Book();
        book.setAuthor("Johnson");
        book.setCart(cart2);
        book.setGenre(Genre.FICTION);
        book.setId(1L);
        book.setIsbn("0-13-149505-0");
        book.setPrice(10.0d);
        book.setTitle("Java");
        book.setYearOfPublication("1990");
        Optional<Book> ofResult = Optional.of(book);
        when(bookRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Book actualUniqueBook = bookServiceImpl.getUniqueBook(1L);
        verify(bookRepository).findById(Mockito.<Long>any());
        assertSame(book, actualUniqueBook);
    }


    @Test
    void testGetUniqueBook2() {
        Optional<Book> emptyResult = Optional.empty();
        when(bookRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);
        assertThrows(CustomException.class, () -> bookServiceImpl.getUniqueBook(1L));
        verify(bookRepository).findById(Mockito.<Long>any());
    }


    @Test
    void testGetUniqueBookWithThrows() {
        when(bookRepository.findById(Mockito.<Long>any())).thenThrow(new CustomException("An error occurred"));
        assertThrows(CustomException.class, () -> bookServiceImpl.getUniqueBook(1L));
        verify(bookRepository).findById(Mockito.<Long>any());
    }


}
