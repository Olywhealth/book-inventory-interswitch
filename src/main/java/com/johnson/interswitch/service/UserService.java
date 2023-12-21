package com.johnson.interswitch.service;


import com.johnson.interswitch.payload.request.UserRequest;
import com.johnson.interswitch.payload.response.UserRegistrationResponse;


public interface UserService {


    UserRegistrationResponse userRegistration(UserRequest request);

}
