package com.API.Movies.controller;

import com.API.Movies.entity.MovieDTO;
import com.API.Movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;


//    Para cambiar el valor por defecto de una peticion restfull(JSON) a XML
    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE})
    public ArrayList<MovieDTO> getAllMovies(){
        return movieService.findAllMovies();
    }

    @PostMapping(produces = {MediaType.APPLICATION_XML_VALUE})
    public MovieDTO saveMovie(@RequestBody MovieDTO movieDTO){
    return movieService.updateMovie(movieDTO);
    }

    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_XML_VALUE})
    public Optional<MovieDTO> findMovieById(@PathVariable("id")Long id){
        return movieService.findById(id);
    }

    @GetMapping(path = "/year",produces = {MediaType.APPLICATION_XML_VALUE})
    public ArrayList<MovieDTO> findAllMoviesByYear(@RequestParam("year")int year){
        return movieService.findAllByYear(year);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMovieById(@PathVariable("id")Long id){
        movieService.deleteMovieById(id);
    }
}