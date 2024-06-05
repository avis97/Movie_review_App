package com.UserMicroservice.UserMicroservice.Controller;

import com.UserMicroservice.UserMicroservice.Entitys.User;
import com.UserMicroservice.UserMicroservice.Exception.ResourceNotFoundException;
import com.UserMicroservice.UserMicroservice.Service.Impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    @GetMapping("/id/{userId}")
    @CircuitBreaker(name = "circuitMovieBreaker" ,fallbackMethod = "movieFallBackMethod")
    public ResponseEntity<User> findUserById(@PathVariable("userId") int userId) throws ResourceNotFoundException{
        User user=userService.findUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }
    //create fallback method for circuit breaker

    public ResponseEntity<User> movieFallBackMethod(int userId,Exception ex){
        User user=User.builder()
                .firstName("Amiya")
                .lastName("Kar")
                .email("dummy@gmail.com")
                .about("RF")
                .number("9788797868")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList=userService.getAllUser();
        return new ResponseEntity<>(userList,HttpStatus.ACCEPTED);
    }
}
