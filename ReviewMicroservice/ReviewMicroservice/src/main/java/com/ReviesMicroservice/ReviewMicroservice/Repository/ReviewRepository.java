package com.ReviesMicroservice.ReviewMicroservice.Repository;

import com.ReviesMicroservice.ReviewMicroservice.Entitys.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer>{
    List<Review> findByUserId(int userId);
    List<Review> findByMovieId(int hotelId);

}
