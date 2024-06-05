package com.UserMicroservice.UserMicroservice.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie{
    private int id;
    private String movieName;
    private String language;
    private String releaseDate;
    private String about;
}
