package com.UserMicroservice.UserMicroservice.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handelGlobalException(ResourceNotFoundException ex){
          String msg=ex.getMessage();
         ApiResponse response= ApiResponse.builder()
                  .msg(msg)
                  .success(false)
                  .status(HttpStatus.NOT_FOUND).build();
          return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
