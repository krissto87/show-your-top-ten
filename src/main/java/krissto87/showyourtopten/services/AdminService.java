package krissto87.showyourtopten.services;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieDTO;

import java.util.List;

public interface AdminService {
    void addMovie(AddMovieDTO addMovieDTO);

    List<Movie> findAll();

    Movie findById(Long id);

    void remove(Movie movie);

    void save(Movie movie);
}
