package com.API.Movies.repository;

import com.API.Movies.entity.MovieDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovieRepository extends CrudRepository<MovieDTO,Long> {

    MovieDTO findByTitle(String title);
    ArrayList<MovieDTO> findAllByYear(int year);
}
