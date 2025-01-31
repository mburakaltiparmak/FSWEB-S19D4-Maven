package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")

public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }
    @GetMapping("/{id}")
    public Movie findById(@PathVariable("id") Long id){
        return movieService.findById(id);
    }
    @PostMapping
    public Movie save(@RequestBody Movie movie){
        return movieService.save(movie);
    }
    @PutMapping("/{id}")
    public Movie update(@PathVariable("id") Long id, @RequestBody Movie movie){
        return movieService.update(id,movie);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        Movie deletedMovie = movieService.findById(id);
        movieService.delete(deletedMovie);
        System.out.println(deletedMovie.getName() + " " + "named movie has been deleted!");
    }
}
