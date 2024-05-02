package com.example.Backend.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionPersonnalize extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ExceptionNotFound.class})
    public ResponseEntity<Object> handleNotFoundResource(ExceptionNotFound exceptionNotFound) {

        ApiError apiError = new ApiError(exceptionNotFound.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(exceptionNotFound.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({TokenExpiredException.class})
    public ResponseEntity<Object> handleTokenExpiredException(TokenExpiredException tokenExpiredException) {

        ApiError apiError = new ApiError(tokenExpiredException.getMessage(), HttpStatus.UNAUTHORIZED, LocalDateTime.now());
        return new ResponseEntity<>(tokenExpiredException.getMessage(), new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
}
