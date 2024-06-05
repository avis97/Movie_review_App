package com.ReviesMicroservice.ReviewMicroservice.Service;

import com.ReviesMicroservice.ReviewMicroservice.Entitys.Review;

import java.util.List;

public interface ReviewService{

    Review craeteReview(Review review);
    List<Review> getAllReview();
    List<Review> getReviewByUserId(int userId);
    List<Review> getReviewByMovieId(int movieId);
}
