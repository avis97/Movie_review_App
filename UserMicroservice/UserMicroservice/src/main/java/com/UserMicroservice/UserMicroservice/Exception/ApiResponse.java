package com.UserMicroservice.UserMicroservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse{
    public String msg;
    public boolean success;
    public HttpStatus status;
}
