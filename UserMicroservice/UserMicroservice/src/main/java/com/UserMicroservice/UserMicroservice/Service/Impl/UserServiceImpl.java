package com.UserMicroservice.UserMicroservice.Service.Impl;

import com.UserMicroservice.UserMicroservice.Entitys.Movie;
import com.UserMicroservice.UserMicroservice.Entitys.Review;
import com.UserMicroservice.UserMicroservice.Entitys.User;
import com.UserMicroservice.UserMicroservice.Exception.ResourceNotFoundException;
import com.UserMicroservice.UserMicroservice.Repository.UserRepository;
import com.UserMicroservice.UserMicroservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public User saveUser(User user){
        User user1=userRepository.save(user);
        return user1;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList=userRepository.findAll();
        return userList;
    }

    @Override
    public User findUserById(int userId) throws ResourceNotFoundException {
        User user=userRepository.
                findById(userId)
                .orElseThrow(()->
                        new ResourceNotFoundException
                                ("User Not Found With This id "+userId));
        Review[] listOfRefiew=
                restTemplate.getForObject("http://REVIEW-SERVICE/review/allbyuserid/"
                        +user.getId(),Review[].class);

        List<Review> reviews= Arrays.stream(listOfRefiew).toList();

        List<Review> reviewList=reviews.stream().map(review ->{
            ResponseEntity<Movie> movie=
                    restTemplate.getForEntity("http://MOVIE-SERVICE/movie/id/"
                            +review.getMovieId(),Movie.class);
            Movie movie1=movie.getBody();
            review.setMovie(movie1);
            return review;
        }).collect(Collectors.toList());
        user.setListReview(reviewList);
        return user;
    }
}
