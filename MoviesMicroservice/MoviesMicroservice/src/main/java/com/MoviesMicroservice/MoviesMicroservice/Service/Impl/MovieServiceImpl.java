package com.MoviesMicroservice.MoviesMicroservice.Service.Impl;

import com.MoviesMicroservice.MoviesMicroservice.Entitys.Movie;
import com.MoviesMicroservice.MoviesMicroservice.Exception.ResourceNotFound;
import com.MoviesMicroservice.MoviesMicroservice.Repository.MovieRepository;
import com.MoviesMicroservice.MoviesMicroservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;
    @Override
    public Movie createMovie(Movie movie) {
        Movie movie1=movieRepository.save(movie);
        return movie1;
    }
    @Override
    public List<Movie> allMovie() {
        List<Movie> list=movieRepository.findAll();
        return list;
    }
    @Override
    public Movie getMovieById(int movieId) throws ResourceNotFound {
        Movie movie=movieRepository.findById(movieId)
                .orElseThrow(()->
                        new ResourceNotFound(
                                "Movie Not Found With This Id "+movieId));
        return movie;
    }
}
