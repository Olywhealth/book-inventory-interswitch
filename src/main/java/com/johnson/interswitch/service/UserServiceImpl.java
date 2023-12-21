package com.johnson.interswitch.service;

import com.johnson.interswitch.contracts.ExtractRequestResponse;
import com.johnson.interswitch.exception.CustomException;
import com.johnson.interswitch.model.User;
import com.johnson.interswitch.payload.request.UserRequest;
import com.johnson.interswitch.payload.response.UserRegistrationResponse;
import com.johnson.interswitch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



    @ExtractRequestResponse
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





}
