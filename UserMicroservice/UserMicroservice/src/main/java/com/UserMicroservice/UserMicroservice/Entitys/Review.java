package com.UserMicroservice.UserMicroservice.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review{
    private int id;
    private int userId;
    private int movieId;
    private int rating;
    private String reviewDetails;
    private LocalDateTime creationTime;
    private Movie movie;

}
