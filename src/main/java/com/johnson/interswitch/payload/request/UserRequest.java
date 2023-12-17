package com.johnson.interswitch.payload.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;

/**
 * @author Johnson on 17/12/2023
 */
public record UserRequest(
        @NonNull()
        @NotEmpty
        String name,
        @Pattern(regexp = "^(.+)@(\\S+)$", message = "Enter a valid email address")
        String email,
        @Pattern(regexp = "(?:(?:(?:\\+?234(?:\\h1)?|01)\\h*)?(?:\\(\\d{3}\\)|\\d{3})|\\d{4})(?:\\W*\\d{3})?\\W*\\d{4}(?!\\d)",
                message = "Enter a valid phone number")
        String phoneNumber
) {
}
