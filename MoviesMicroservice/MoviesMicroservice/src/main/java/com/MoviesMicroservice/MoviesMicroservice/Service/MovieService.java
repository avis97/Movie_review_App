package com.MoviesMicroservice.MoviesMicroservice.Service;

import com.MoviesMicroservice.MoviesMicroservice.Entitys.Movie;
import com.MoviesMicroservice.MoviesMicroservice.Exception.ResourceNotFound;

import java.util.*;
public interface MovieService{
   Movie createMovie(Movie movie);
   List<Movie> allMovie();
   Movie getMovieById(int movieId) throws ResourceNotFound;
}
