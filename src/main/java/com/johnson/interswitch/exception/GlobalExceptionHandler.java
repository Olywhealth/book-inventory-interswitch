package com.johnson.interswitch.exception;

import com.johnson.interswitch.payload.response.GenericResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        GenericResponse<?> response = new GenericResponse<>();
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", System.currentTimeMillis());
        body.put("status", status.value());

        ex.getBindingResult().getFieldErrors().forEach(x -> {
            body.put(x.getField(), x.getDefaultMessage());
        });
        response.setData(null);
        response.setError(List.of(body));
        return new ResponseEntity<>(body, status);
    }


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<GenericResponse<?>> handleException(CustomException ex) {
        GenericResponse<?> response = new GenericResponse<>();
        response.setData(null);
        response.setError(Collections.singletonList(ex.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
