package com.johnson.interswitch.service;

import com.johnson.interswitch.contracts.ExtractRequestResponse;
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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final TransactionHistoryRepository transactionRepository;
    private final BookRepository bookRepository;

    @Transactional
    public CheckoutResponse checkoutCart(Long userId) {
        log.info("User attempting checkout ::::: {}", userId);
        TransactionHistory transaction = new TransactionHistory();
        Optional<User> cartOwner = userRepository.findById(userId);
        UserCart userCart = cartRepository.findCartByUser(cartOwner.get());
        if (userCart == null) {
            log.warn("An error occurred: user cart is empty");
            throw new CustomException("Your cart is empty add a few books before checkout!");
        }
        List<Book> cartBooks = userCart.getBooks();
        CheckoutResponse response = new CheckoutResponse();
        response.setOrderedBooks(cartBooks);
        transaction.setBookList(cartBooks);
        transaction.setUser(cartOwner.get());
        transaction.setAmount(response.getPayableAmount());
        transaction.setCreatedAt(LocalDateTime.now());
        transactionRepository.save(transaction);
        cartRepository.deleteAll();
        log.info("User successfully checkout :::: {}", userId);
        return response;
    }

    public UserCart getUserCart(Long userid) {
        Optional<User> cartOwner = userRepository.findById(userid);
        UserCart userCart = cartRepository.findCartByUser(cartOwner.get());
        if (userCart == null) {
            log.warn("An error occurred: user cart is empty");
            throw new CustomException("Your cart is empty add a few books!");
        }
        return userCart;
    }

    @Transactional
    @ExtractRequestResponse
    public void addBookToCart(Long bookId, Long userId) {
        Optional<User> cartOwner = userRepository.findById(userId);
        Book bookToAdd = getBook(bookId);
        UserCart userCart = cartOwner.get().getCart();
        if (userCart == null) {
            userCart = new UserCart();
        }
        userCart.setUser(cartOwner.get());
        userCart.setCreatedAt(LocalDateTime.now());
        userCart.getBooks().add(bookToAdd);
        cartRepository.save(userCart);
        bookToAdd.setCart(userCart);
        bookRepository.save(bookToAdd);
    }

    private Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(()-> new CustomException("No book with ID: "+id));
    }

}
