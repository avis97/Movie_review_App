package com.ReviesMicroservice.ReviewMicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle{

    public ResponseEntity<ApiResponse> GlobalExceptionHandler(ResourceNotFoundException ex){
        String msg=ex.getMessage();
        ApiResponse response=ApiResponse.builder()
                .massage(msg)
                .success(false)
                .status(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }

}
