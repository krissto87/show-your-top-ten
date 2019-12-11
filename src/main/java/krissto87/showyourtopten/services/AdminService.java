package krissto87.showyourtopten.services;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieDTO;
import krissto87.showyourtopten.dtos.AddSerialDTO;
import krissto87.showyourtopten.dtos.EditMovieDTO;

import java.util.List;

public interface AdminService {
    void addMovie(AddMovieDTO addMovieDTO);

    List<Movie> findAll();

    EditMovieDTO findById(Long id);

    void save(EditMovieDTO movieDTO);

    void deleteById(Long id);

    void addSerial(AddSerialDTO serial);
}
