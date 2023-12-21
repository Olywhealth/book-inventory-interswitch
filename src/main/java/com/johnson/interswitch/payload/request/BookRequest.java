package com.johnson.interswitch.payload.request;

import com.johnson.interswitch.enums.Genre;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;

/**
 * @author user on 16/12/2023
 */
public record BookRequest(
        @Pattern(regexp = "\\p{L}{2,}", message = "Title must contain at least two letters")
        String title,
        @NonNull
        Genre genre,
        @Pattern(regexp = "^(?=(?:[^0-9]*[0-9]){10}(?:(?:[^0-9]*[0-9]){3})?$)[\\d-]+$", message = "Enter a valid ISBN number")
        String isbn,
        @Pattern(regexp = "\\p{L}{2,}", message = "Author must contain at least two letters")
        String author,
        @Pattern(regexp = "\\d{4}", message = "Year of publication must be four digits")
        String yearOfPublication,
        Double price
) {
}
