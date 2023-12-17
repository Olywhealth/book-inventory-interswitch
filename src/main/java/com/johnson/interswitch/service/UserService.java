package com.johnson.interswitch.service;


import com.johnson.interswitch.model.UserCart;
import com.johnson.interswitch.payload.request.UserRequest;
import com.johnson.interswitch.payload.response.CheckoutResponse;
import com.johnson.interswitch.payload.response.UserRegistrationResponse;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {


    UserRegistrationResponse userRegistration(UserRequest request);

    void addBookToCart(Long bookId, Long userId);

    @Transactional
    CheckoutResponse checkoutCart(String userEmail);

    UserCart getUserCart(String userEmail);
}
