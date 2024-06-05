package com.MoviesMicroservice.MoviesMicroservice.Controller;

import com.MoviesMicroservice.MoviesMicroservice.Entitys.Movie;
import com.MoviesMicroservice.MoviesMicroservice.Exception.ResourceNotFound;
import com.MoviesMicroservice.MoviesMicroservice.Service.Impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController{
    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/create")
    public ResponseEntity createMovie(@RequestBody Movie movie){
        Movie movie1=movieService.createMovie(movie);
        return new ResponseEntity(movie1, HttpStatus.CREATED);
    }
    @GetMapping("/id/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") int movieId) throws ResourceNotFound {
        Movie movie=movieService.getMovieById(movieId);
        return new ResponseEntity<>(movie,HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> allMovie(){
        List<Movie> movieList=movieService.allMovie();
        return new ResponseEntity<>(movieList,HttpStatus.ACCEPTED);
    }
}
