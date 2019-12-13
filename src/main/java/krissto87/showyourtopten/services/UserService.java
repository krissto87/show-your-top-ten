package krissto87.showyourtopten.services;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieListDTO;
import krissto87.showyourtopten.dtos.EditMovieListDTO;

import java.util.List;

public interface UserService {
    List<Movie> findAll();

    void addMovieList(AddMovieListDTO movieList);

    List<Movie> findUserList();

    EditMovieListDTO getMovieList();

    void save(EditMovieListDTO movieList);

    void deleteUserList();
}
