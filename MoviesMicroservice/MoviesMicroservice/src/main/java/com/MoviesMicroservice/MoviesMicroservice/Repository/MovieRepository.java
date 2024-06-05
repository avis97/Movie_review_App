package com.MoviesMicroservice.MoviesMicroservice.Repository;
import com.MoviesMicroservice.MoviesMicroservice.Entitys.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{

}
