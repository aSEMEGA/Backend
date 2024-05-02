package com.example.Backend.Exception;

public class TokenExpiredException extends RuntimeException{

    public TokenExpiredException(String message) {
        super(message);
    }
}
