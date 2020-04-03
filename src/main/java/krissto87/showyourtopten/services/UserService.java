package krissto87.showyourtopten.services;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieListDto;
import krissto87.showyourtopten.dtos.EditMovieListDto;

import java.util.List;

public interface UserService {
    List<Movie> findAll();

    void addMovieList(AddMovieListDto movieList);

    List<Movie> findUserList();

    EditMovieListDto getMovieList();

    void save(EditMovieListDto movieList);

    void deleteUserList();
}
