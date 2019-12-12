package krissto87.showyourtopten.services;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieListDTO;

import java.util.List;

public interface UserService {
    List<Movie> findAll();

    void addMovieList(AddMovieListDTO movieList);
}
