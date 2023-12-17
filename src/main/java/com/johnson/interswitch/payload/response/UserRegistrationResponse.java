package com.johnson.interswitch.payload.response;

import com.johnson.interswitch.model.User;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Builder
public class UserRegistrationResponse {

    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private LocalDateTime createdAt;

    public static UserRegistrationResponse convertUser(User user) {
        return UserRegistrationResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .build();
    }

}
