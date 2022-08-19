package com.API.Movies.service;

import com.API.Movies.entity.MovieDTO;
import com.API.Movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public Optional<MovieDTO> findById(Long id){
        return movieRepository.findById(id);
    }

    public MovieDTO findByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    public ArrayList<MovieDTO> findAllMovies(){
        return (ArrayList<MovieDTO>) movieRepository.findAll();
    }

    public ArrayList<MovieDTO> findAllByYear(int year){
        return movieRepository.findAllByYear(year);
    }

    public MovieDTO updateMovie(MovieDTO movieDTO){
        return movieRepository.save(movieDTO);
    }

    public void deleteMovieById(Long id){
        movieRepository.deleteById(id);
    }

}
