package com.johnson.interswitch.controller;

import com.johnson.interswitch.payload.request.UserRequest;
import com.johnson.interswitch.payload.response.UserRegistrationResponse;
import com.johnson.interswitch.service.UserService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @ApiOperation(value = "Register new user", notes = "Register new user", response = UserRegistrationResponse.class)
    @PostMapping(value = "/register", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRegistrationResponse> userRegistration(@Valid @RequestBody UserRequest userRequest) {
        UserRegistrationResponse response = service.userRegistration(userRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }






}
