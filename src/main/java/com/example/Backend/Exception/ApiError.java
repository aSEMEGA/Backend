package com.example.Backend.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private String message;

    private HttpStatus httpStatus;

    LocalDateTime localDateTime = LocalDateTime.now();


}
