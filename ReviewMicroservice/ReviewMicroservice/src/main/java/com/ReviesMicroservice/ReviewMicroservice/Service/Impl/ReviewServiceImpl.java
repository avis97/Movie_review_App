package com.ReviesMicroservice.ReviewMicroservice.Service.Impl;

import com.ReviesMicroservice.ReviewMicroservice.Entitys.Review;
import com.ReviesMicroservice.ReviewMicroservice.Repository.ReviewRepository;
import com.ReviesMicroservice.ReviewMicroservice.Service.ReviewService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review craeteReview(Review review) {
        review.setCreationTime(LocalDateTime.now());
        Review review1=reviewRepository.save(review);
        return review1;
    }

    @Override
    public List<Review> getAllReview(){
        List<Review> reviewList=reviewRepository.findAll();
        return  reviewList;
    }


    @Override
    public List<Review> getReviewByUserId(int userId){
        List<Review> reviewList=reviewRepository.findByUserId(userId);
        return reviewList;
    }

    @Override
    public List<Review> getReviewByMovieId(int movieId){
        List<Review> reviewList=reviewRepository.findByMovieId(movieId);
        return reviewList;
    }
}
