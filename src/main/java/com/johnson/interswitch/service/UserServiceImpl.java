package com.johnson.interswitch.service;

import com.johnson.interswitch.exception.CustomException;
import com.johnson.interswitch.model.Book;
import com.johnson.interswitch.model.TransactionHistory;
import com.johnson.interswitch.model.User;
import com.johnson.interswitch.model.UserCart;
import com.johnson.interswitch.payload.request.UserRequest;
import com.johnson.interswitch.payload.response.CheckoutResponse;
import com.johnson.interswitch.payload.response.UserRegistrationResponse;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final BookRepository bookRepository;
    private final TransactionHistoryRepository transactionRepository;



    public UserRegistrationResponse userRegistration(UserRequest request) {
        log.info("Registering new user :::: {}", request.name());
        Optional<User> user = userRepository.findByEmail(request.email());
        if (user.isPresent()) {
            throw new CustomException("User already exist with email " + request.email());
        }
        User newUser = new User();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setPhoneNumber(request.phoneNumber());
        newUser.setCreatedAt(LocalDateTime.now());
        userRepository.save(newUser);
        log.info("Successful registration :::: {}", request.name());
        return UserRegistrationResponse.convertUser(newUser);
    }


    @Transactional
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


    @Transactional
    public CheckoutResponse checkoutCart(String userEmail) {
        log.info("User attempting checkout ::::: {}", userEmail);
        TransactionHistory transaction = new TransactionHistory();
        Optional<User> cartOwner = userRepository.findByEmail(userEmail);
        UserCart userCart = cartRepository.findCartByUser(cartOwner.get());
        if (userCart == null) {
            log.warn("An error occurred: user cart is empty");
            throw new CustomException("Your cart is empty add a few books before checkout!");
        }

        //Here is to calculate the total amount of the books in the user's cart
        List<Book> cartBooks = userCart.getBooks();
        double totalPayableAmount = cartBooks.stream()
                .mapToDouble(Book::getPrice).sum();
        CheckoutResponse response = new CheckoutResponse();
        response.setOrderedBooks(cartBooks);
        response.setPayableAmount(totalPayableAmount);

        // Set transaction properties
        transaction.setCart(userCart);
        transaction.setUser(cartOwner.get());
        transaction.setAmount(totalPayableAmount);
        transaction.setMessage("Order successfully made by "+userEmail);
        transactionRepository.save(transaction);
        userCart.clearCart();
        cartRepository.save(userCart);
        log.info("User successfully checkout :::: {}", userEmail);
        return response;
    }

    public UserCart getUserCart(String userEmail) {
        Optional<User> cartOwner = userRepository.findByEmail(userEmail);
        UserCart userCart = cartRepository.findCartByUser(cartOwner.get());
        if (userCart == null) {
            log.warn("An error occurred: user cart is empty");
            throw new CustomException("Your cart is empty add a few books!");
        }
        return userCart;
    }

    private Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(()-> new CustomException("No book with ID: "+id));
    }


}
