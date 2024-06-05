package com.MoviesMicroservice.MoviesMicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{


    @ExceptionHandler
    public ResponseEntity<ApiResponse> globalException(ResourceNotFound ex){
        String message=ex.getMessage();
        ApiResponse response=ApiResponse.builder()
                .msg(message)
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
