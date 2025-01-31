package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.exception.ApiException;
import com.workintech.s19d1.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@NoArgsConstructor
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{
    private MovieRepository movieRepository;
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(()-> new ApiException("Movie is not found with id:" + " " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Long id, Movie updatedMovie) {
        Movie toBeUpdatedMovie = findById(id);
        toBeUpdatedMovie.setId(updatedMovie.getId());
        toBeUpdatedMovie.setName(updatedMovie.getName());
        toBeUpdatedMovie.setDirectorName(updatedMovie.getDirectorName());
        toBeUpdatedMovie.setRating(updatedMovie.getRating());
        toBeUpdatedMovie.setReleaseDate(updatedMovie.getReleaseDate());
        return toBeUpdatedMovie;
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);

    }
}
