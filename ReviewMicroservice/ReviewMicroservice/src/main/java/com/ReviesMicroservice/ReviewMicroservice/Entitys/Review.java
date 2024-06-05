package com.ReviesMicroservice.ReviewMicroservice.Entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private int userId;
    private int movieId;
    private int rating;
    private String reviewDetails;
    private LocalDateTime creationTime;

}
