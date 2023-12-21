package com.johnson.interswitch.service;


import com.johnson.interswitch.model.UserCart;
import com.johnson.interswitch.payload.response.CheckoutResponse;
public interface CartService {
    CheckoutResponse checkoutCart(Long userId);

    UserCart getUserCart(Long userid);

    void addBookToCart(Long bookId, Long userId);
}
