package com.johnson.interswitch.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.johnson.interswitch.enums.Genre;
import com.johnson.interswitch.exception.CustomException;
import com.johnson.interswitch.model.Book;
import com.johnson.interswitch.model.TransactionHistory;
import com.johnson.interswitch.model.User;
import com.johnson.interswitch.model.UserCart;
import com.johnson.interswitch.payload.response.CheckoutResponse;
import com.johnson.interswitch.repository.BookRepository;
import com.johnson.interswitch.repository.CartRepository;
import com.johnson.interswitch.repository.TransactionHistoryRepository;
import com.johnson.interswitch.repository.UserRepository;

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

@ContextConfiguration(classes = {CartServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CartServiceImplTest {
    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @MockBean
    private TransactionHistoryRepository transactionHistoryRepository;

    @MockBean
    private UserRepository userRepository;

   
    @Test
    void testCheckoutCart() {
        UserCart cart = new UserCart();
        cart.setBooks(new ArrayList<>());
        cart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart.setId(1L);
        cart.setUser(new User());

        User user = new User();
        user.setCart(cart);
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("johnson@example.com");
        user.setId(1L);
        user.setName("Johnson");
        user.setPhoneNumber("+234567890");
        user.setTransactionHistories(new ArrayList<>());

        UserCart cart2 = new UserCart();
        cart2.setBooks(new ArrayList<>());
        cart2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart2.setId(1L);
        cart2.setUser(user);

        User user2 = new User();
        user2.setCart(cart2);
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("johnson@example.com");
        user2.setId(1L);
        user2.setName("Johnson");
        user2.setPhoneNumber("+234567890");
        user2.setTransactionHistories(new ArrayList<>());

        UserCart userCart = new UserCart();
        userCart.setBooks(new ArrayList<>());
        userCart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        userCart.setId(1L);
        userCart.setUser(user2);
        doNothing().when(cartRepository).deleteAll();
        when(cartRepository.findCartByUser(Mockito.<User>any())).thenReturn(userCart);

        UserCart cart3 = new UserCart();
        cart3.setBooks(new ArrayList<>());
        cart3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart3.setId(1L);
        cart3.setUser(new User());

        User user3 = new User();
        user3.setCart(cart3);
        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("johnson@example.com");
        user3.setId(1L);
        user3.setName("Johnson");
        user3.setPhoneNumber("+234567890");
        user3.setTransactionHistories(new ArrayList<>());

        UserCart cart4 = new UserCart();
        cart4.setBooks(new ArrayList<>());
        cart4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart4.setId(1L);
        cart4.setUser(user3);

        User user4 = new User();
        user4.setCart(cart4);
        user4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("johnson@example.com");
        user4.setId(1L);
        user4.setName("Johnson");
        user4.setPhoneNumber("+234567890");
        user4.setTransactionHistories(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user4);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        User user5 = new User();
        user5.setCart(new UserCart());
        user5.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("johnson@example.com");
        user5.setId(1L);
        user5.setName("Johnson");
        user5.setPhoneNumber("+234567890");
        user5.setTransactionHistories(new ArrayList<>());

        UserCart cart5 = new UserCart();
        cart5.setBooks(new ArrayList<>());
        cart5.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart5.setId(1L);
        cart5.setUser(user5);

        User user6 = new User();
        user6.setCart(cart5);
        user6.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user6.setEmail("johnson@example.com");
        user6.setId(1L);
        user6.setName("Johnson");
        user6.setPhoneNumber("+234567890");
        user6.setTransactionHistories(new ArrayList<>());

        UserCart cart6 = new UserCart();
        cart6.setBooks(new ArrayList<>());
        cart6.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart6.setId(1L);
        cart6.setUser(user6);

        UserCart cart7 = new UserCart();
        cart7.setBooks(new ArrayList<>());
        cart7.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart7.setId(1L);
        cart7.setUser(new User());

        User user7 = new User();
        user7.setCart(cart7);
        user7.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user7.setEmail("johnson@example.com");
        user7.setId(1L);
        user7.setName("Johnson");
        user7.setPhoneNumber("+234567890");
        user7.setTransactionHistories(new ArrayList<>());

        UserCart cart8 = new UserCart();
        cart8.setBooks(new ArrayList<>());
        cart8.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart8.setId(1L);
        cart8.setUser(user7);

        User user8 = new User();
        user8.setCart(cart8);
        user8.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user8.setEmail("johnson@example.com");
        user8.setId(1L);
        user8.setName("Johnson");
        user8.setPhoneNumber("+234567890");
        user8.setTransactionHistories(new ArrayList<>());

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setAmount(10.0d);
        transactionHistory.setCart(cart6);
        transactionHistory.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        transactionHistory.setId(1L);
        transactionHistory.setMessage("Not all who wander are lost");
        transactionHistory.setUser(user8);
        when(transactionHistoryRepository.save(Mockito.<TransactionHistory>any())).thenReturn(transactionHistory);
        CheckoutResponse actualCheckoutCartResult = cartServiceImpl.checkoutCart(1L);
        verify(cartRepository).findCartByUser(Mockito.<User>any());
        verify(cartRepository).deleteAll();
        verify(userRepository).findById(Mockito.<Long>any());
        verify(transactionHistoryRepository).save(Mockito.<TransactionHistory>any());
        assertTrue(actualCheckoutCartResult.getOrderedBooks().isEmpty());
    }

   
    @Test
    void testCheckoutCart2() {
        UserCart cart = new UserCart();
        cart.setBooks(new ArrayList<>());
        cart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart.setId(1L);
        cart.setUser(new User());

        User user = new User();
        user.setCart(cart);
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("johnson@example.com");
        user.setId(1L);
        user.setName("Johnson");
        user.setPhoneNumber("+234567890");
        user.setTransactionHistories(new ArrayList<>());

        UserCart cart2 = new UserCart();
        cart2.setBooks(new ArrayList<>());
        cart2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart2.setId(1L);
        cart2.setUser(user);

        User user2 = new User();
        user2.setCart(cart2);
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("johnson@example.com");
        user2.setId(1L);
        user2.setName("Johnson");
        user2.setPhoneNumber("+234567890");
        user2.setTransactionHistories(new ArrayList<>());

        UserCart userCart = new UserCart();
        userCart.setBooks(new ArrayList<>());
        userCart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        userCart.setId(1L);
        userCart.setUser(user2);
        when(cartRepository.findCartByUser(Mockito.<User>any())).thenReturn(userCart);

        UserCart cart3 = new UserCart();
        cart3.setBooks(new ArrayList<>());
        cart3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart3.setId(1L);
        cart3.setUser(new User());

        User user3 = new User();
        user3.setCart(cart3);
        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("johnson@example.com");
        user3.setId(1L);
        user3.setName("Johnson");
        user3.setPhoneNumber("+234567890");
        user3.setTransactionHistories(new ArrayList<>());

        UserCart cart4 = new UserCart();
        cart4.setBooks(new ArrayList<>());
        cart4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart4.setId(1L);
        cart4.setUser(user3);

        User user4 = new User();
        user4.setCart(cart4);
        user4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("johnson@example.com");
        user4.setId(1L);
        user4.setName("Johnson");
        user4.setPhoneNumber("+234567890");
        user4.setTransactionHistories(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user4);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        when(transactionHistoryRepository.save(Mockito.<TransactionHistory>any()))
                .thenThrow(new CustomException("An error occurred"));
        assertThrows(CustomException.class, () -> cartServiceImpl.checkoutCart(1L));
        verify(cartRepository).findCartByUser(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
        verify(transactionHistoryRepository).save(Mockito.<TransactionHistory>any());
    }

    
    @Test
    void testGetUserCart() {
        UserCart cart = new UserCart();
        cart.setBooks(new ArrayList<>());
        cart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart.setId(1L);
        cart.setUser(new User());

        User user = new User();
        user.setCart(cart);
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("johnson@example.com");
        user.setId(1L);
        user.setName("Johnson");
        user.setPhoneNumber("+234567890");
        user.setTransactionHistories(new ArrayList<>());

        UserCart cart2 = new UserCart();
        cart2.setBooks(new ArrayList<>());
        cart2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart2.setId(1L);
        cart2.setUser(user);

        User user2 = new User();
        user2.setCart(cart2);
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("johnson@example.com");
        user2.setId(1L);
        user2.setName("Johnson");
        user2.setPhoneNumber("+234567890");
        user2.setTransactionHistories(new ArrayList<>());

        UserCart userCart = new UserCart();
        userCart.setBooks(new ArrayList<>());
        userCart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        userCart.setId(1L);
        userCart.setUser(user2);
        when(cartRepository.findCartByUser(Mockito.<User>any())).thenReturn(userCart);

        UserCart cart3 = new UserCart();
        cart3.setBooks(new ArrayList<>());
        cart3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart3.setId(1L);
        cart3.setUser(new User());

        User user3 = new User();
        user3.setCart(cart3);
        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("johnson@example.com");
        user3.setId(1L);
        user3.setName("Johnson");
        user3.setPhoneNumber("+234567890");
        user3.setTransactionHistories(new ArrayList<>());

        UserCart cart4 = new UserCart();
        cart4.setBooks(new ArrayList<>());
        cart4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart4.setId(1L);
        cart4.setUser(user3);

        User user4 = new User();
        user4.setCart(cart4);
        user4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("johnson@example.com");
        user4.setId(1L);
        user4.setName("Johnson");
        user4.setPhoneNumber("+234567890");
        user4.setTransactionHistories(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user4);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        UserCart actualUserCart = cartServiceImpl.getUserCart(1L);
        verify(cartRepository).findCartByUser(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
        assertSame(userCart, actualUserCart);
    }

    
    @Test
    void testGetUserCart2() {
        when(cartRepository.findCartByUser(Mockito.<User>any())).thenThrow(new CustomException("An error occurred"));

        UserCart cart = new UserCart();
        cart.setBooks(new ArrayList<>());
        cart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart.setId(1L);
        cart.setUser(new User());

        User user = new User();
        user.setCart(cart);
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("johnson@example.com");
        user.setId(1L);
        user.setName("Johnson");
        user.setPhoneNumber("+234567890");
        user.setTransactionHistories(new ArrayList<>());

        UserCart cart2 = new UserCart();
        cart2.setBooks(new ArrayList<>());
        cart2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart2.setId(1L);
        cart2.setUser(user);

        User user2 = new User();
        user2.setCart(cart2);
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("johnson@example.com");
        user2.setId(1L);
        user2.setName("Johnson");
        user2.setPhoneNumber("+234567890");
        user2.setTransactionHistories(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user2);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(CustomException.class, () -> cartServiceImpl.getUserCart(1L));
        verify(cartRepository).findCartByUser(Mockito.<User>any());
        verify(userRepository).findById(Mockito.<Long>any());
    }


    @Test
    void testAddBookToCart() {
        UserCart cart = new UserCart();
        cart.setBooks(new ArrayList<>());
        cart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart.setId(1L);
        cart.setUser(new User());

        User user = new User();
        user.setCart(cart);
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("johnson@example.com");
        user.setId(1L);
        user.setName("Johnson");
        user.setPhoneNumber("+234567890");
        user.setTransactionHistories(new ArrayList<>());

        UserCart cart2 = new UserCart();
        cart2.setBooks(new ArrayList<>());
        cart2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart2.setId(1L);
        cart2.setUser(user);

        User user2 = new User();
        user2.setCart(cart2);
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("johnson@example.com");
        user2.setId(1L);
        user2.setName("Johnson");
        user2.setPhoneNumber("+234567890");
        user2.setTransactionHistories(new ArrayList<>());

        UserCart userCart = new UserCart();
        userCart.setBooks(new ArrayList<>());
        userCart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        userCart.setId(1L);
        userCart.setUser(user2);
        when(cartRepository.save(Mockito.<UserCart>any())).thenReturn(userCart);

        UserCart cart3 = new UserCart();
        cart3.setBooks(new ArrayList<>());
        cart3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart3.setId(1L);
        cart3.setUser(new User());

        User user3 = new User();
        user3.setCart(cart3);
        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("johnson@example.com");
        user3.setId(1L);
        user3.setName("Johnson");
        user3.setPhoneNumber("+234567890");
        user3.setTransactionHistories(new ArrayList<>());

        UserCart cart4 = new UserCart();
        cart4.setBooks(new ArrayList<>());
        cart4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart4.setId(1L);
        cart4.setUser(user3);

        User user4 = new User();
        user4.setCart(cart4);
        user4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("johnson@example.com");
        user4.setId(1L);
        user4.setName("Johnson");
        user4.setPhoneNumber("+234567890");
        user4.setTransactionHistories(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user4);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        UserCart cart5 = new UserCart();
        cart5.setBooks(new ArrayList<>());
        cart5.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart5.setId(1L);
        cart5.setUser(new User());

        User user5 = new User();
        user5.setCart(cart5);
        user5.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("johnson@example.com");
        user5.setId(1L);
        user5.setName("Johnson");
        user5.setPhoneNumber("+234567890");
        user5.setTransactionHistories(new ArrayList<>());

        UserCart cart6 = new UserCart();
        cart6.setBooks(new ArrayList<>());
        cart6.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart6.setId(1L);
        cart6.setUser(user5);

        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setCart(cart6);
        book.setGenre(Genre.FICTION);
        book.setId(1L);
        book.setIsbn("Isbn");
        book.setPrice(10.0d);
        book.setTitle("Dr");
        book.setYearOfPublication("Year Of Publication");
        Optional<Book> ofResult2 = Optional.of(book);

        User user6 = new User();
        user6.setCart(new UserCart());
        user6.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user6.setEmail("johnson@example.com");
        user6.setId(1L);
        user6.setName("Johnson");
        user6.setPhoneNumber("+234567890");
        user6.setTransactionHistories(new ArrayList<>());

        UserCart cart7 = new UserCart();
        cart7.setBooks(new ArrayList<>());
        cart7.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart7.setId(1L);
        cart7.setUser(user6);

        User user7 = new User();
        user7.setCart(cart7);
        user7.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user7.setEmail("johnson@example.com");
        user7.setId(1L);
        user7.setName("Johnson");
        user7.setPhoneNumber("+234567890");
        user7.setTransactionHistories(new ArrayList<>());

        UserCart cart8 = new UserCart();
        cart8.setBooks(new ArrayList<>());
        cart8.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart8.setId(1L);
        cart8.setUser(user7);

        Book book2 = new Book();
        book2.setAuthor("JaneDoe");
        book2.setCart(cart8);
        book2.setGenre(Genre.FICTION);
        book2.setId(1L);
        book2.setIsbn("Isbn");
        book2.setPrice(10.0d);
        book2.setTitle("Dr");
        book2.setYearOfPublication("Year Of Publication");
        when(bookRepository.save(Mockito.<Book>any())).thenReturn(book2);
        when(bookRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        cartServiceImpl.addBookToCart(1L, 1L);
        verify(bookRepository).findById(Mockito.<Long>any());
        verify(userRepository).findById(Mockito.<Long>any());
        verify(bookRepository).save(Mockito.<Book>any());
        verify(cartRepository).save(Mockito.<UserCart>any());
    }


    @Test
    void testAddBookToCart2() {
        UserCart cart = new UserCart();
        cart.setBooks(new ArrayList<>());
        cart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart.setId(1L);
        cart.setUser(new User());

        User user = new User();
        user.setCart(cart);
        user.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("johnson@example.com");
        user.setId(1L);
        user.setName("Johnson");
        user.setPhoneNumber("+234567890");
        user.setTransactionHistories(new ArrayList<>());

        UserCart cart2 = new UserCart();
        cart2.setBooks(new ArrayList<>());
        cart2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart2.setId(1L);
        cart2.setUser(user);

        User user2 = new User();
        user2.setCart(cart2);
        user2.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("johnson@example.com");
        user2.setId(1L);
        user2.setName("Johnson");
        user2.setPhoneNumber("+234567890");
        user2.setTransactionHistories(new ArrayList<>());

        UserCart userCart = new UserCart();
        userCart.setBooks(new ArrayList<>());
        userCart.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        userCart.setId(1L);
        userCart.setUser(user2);
        when(cartRepository.save(Mockito.<UserCart>any())).thenReturn(userCart);

        UserCart cart3 = new UserCart();
        cart3.setBooks(new ArrayList<>());
        cart3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart3.setId(1L);
        cart3.setUser(new User());

        User user3 = new User();
        user3.setCart(cart3);
        user3.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("johnson@example.com");
        user3.setId(1L);
        user3.setName("Johnson");
        user3.setPhoneNumber("+234567890");
        user3.setTransactionHistories(new ArrayList<>());

        UserCart cart4 = new UserCart();
        cart4.setBooks(new ArrayList<>());
        cart4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart4.setId(1L);
        cart4.setUser(user3);

        User user4 = new User();
        user4.setCart(cart4);
        user4.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("johnson@example.com");
        user4.setId(1L);
        user4.setName("Johnson");
        user4.setPhoneNumber("+234567890");
        user4.setTransactionHistories(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user4);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        UserCart cart5 = new UserCart();
        cart5.setBooks(new ArrayList<>());
        cart5.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart5.setId(1L);
        cart5.setUser(new User());

        User user5 = new User();
        user5.setCart(cart5);
        user5.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("johnson@example.com");
        user5.setId(1L);
        user5.setName("Johnson");
        user5.setPhoneNumber("+234567890");
        user5.setTransactionHistories(new ArrayList<>());

        UserCart cart6 = new UserCart();
        cart6.setBooks(new ArrayList<>());
        cart6.setCreatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        cart6.setId(1L);
        cart6.setUser(user5);

        Book book = new Book();
        book.setAuthor("JaneDoe");
        book.setCart(cart6);
        book.setGenre(Genre.FICTION);
        book.setId(1L);
        book.setIsbn("Isbn");
        book.setPrice(10.0d);
        book.setTitle("Dr");
        book.setYearOfPublication("Year Of Publication");
        Optional<Book> ofResult2 = Optional.of(book);
        when(bookRepository.save(Mockito.<Book>any())).thenThrow(new CustomException("An error occurred"));
        when(bookRepository.findById(Mockito.<Long>any())).thenReturn(ofResult2);
        assertThrows(CustomException.class, () -> cartServiceImpl.addBookToCart(1L, 1L));
        verify(bookRepository).findById(Mockito.<Long>any());
        verify(userRepository).findById(Mockito.<Long>any());
        verify(bookRepository).save(Mockito.<Book>any());
        verify(cartRepository).save(Mockito.<UserCart>any());
    }
}
