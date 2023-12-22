package com.johnson.interswitch.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.johnson.interswitch.exception.CustomException;
import com.johnson.interswitch.model.User;
import com.johnson.interswitch.model.UserCart;
import com.johnson.interswitch.payload.request.UserRequest;
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

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testUserRegistration() {
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
        when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
        assertThrows(CustomException.class,
                () -> userServiceImpl.userRegistration(new UserRequest("Johnson", "johnson@example.com", "+234567890")));
        verify(userRepository).findByEmail(Mockito.<String>any());
    }
}
