package com.johnson.interswitch.controller;

import com.johnson.interswitch.model.UserCart;
import com.johnson.interswitch.payload.response.CheckoutResponse;
import com.johnson.interswitch.service.CartService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @ApiOperation(value = "Get user cart", notes = "Get user cart", response = UserCart.class)
    @GetMapping(value = "/user_cart", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserCart> getUserCart(Long userid) {
       UserCart userCart = cartService.getUserCart(userid);
       return new ResponseEntity<>(userCart, HttpStatus.OK);
    }

    @ApiOperation(value = "Cart checkout", notes = "Cart checkout", response = CheckoutResponse.class)
    @PostMapping(value = "checkout", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CheckoutResponse> cartCheckOut(Long userId) {
       CheckoutResponse response = cartService.checkoutCart(userId);
       return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Add book to cart", notes = "Add to cart", response = CheckoutResponse.class)
    @PostMapping(value = "/{bookId}/{userId}/addToCart", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToUserCart(@PathVariable Long bookId, @PathVariable Long userId) {
        cartService.addBookToCart(bookId, userId);
        return new ResponseEntity<>("Successfully added book to your cart", HttpStatus.OK);
    }

}
