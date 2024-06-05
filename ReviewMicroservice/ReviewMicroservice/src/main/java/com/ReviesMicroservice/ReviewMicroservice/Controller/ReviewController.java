package com.ReviesMicroservice.ReviewMicroservice.Controller;

import com.ReviesMicroservice.ReviewMicroservice.Entitys.Review;
import com.ReviesMicroservice.ReviewMicroservice.Service.Impl.ReviewServiceImpl;
import com.ReviesMicroservice.ReviewMicroservice.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController{

    @Autowired
    ReviewServiceImpl reviewService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        Review review1=reviewService.craeteReview(review);
        return new ResponseEntity<>(review1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> allReview(){
        List<Review> reviewList=reviewService.getAllReview();
        return new ResponseEntity<>(reviewList,HttpStatus.ACCEPTED);
    }
    @GetMapping("/allbyuserid/{userId}")
    public ResponseEntity<List<Review>> getAllByUserId(@PathVariable("userId") int userId){
        List<Review> list=reviewService.getReviewByUserId(userId);
        return new  ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }
    @GetMapping("/allbymovieid/{movieId}")
    public ResponseEntity<List<Review>> getAllByMovieId(@PathVariable("movieId") int movieId){
        List<Review> list=reviewService.getReviewByMovieId(movieId);
        return new  ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }

}
