package krissto87.showyourtopten.services;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.entities.Serial;
import krissto87.showyourtopten.dtos.AddMovieDTO;
import krissto87.showyourtopten.dtos.AddSerialDTO;
import krissto87.showyourtopten.dtos.EditMovieDTO;
import krissto87.showyourtopten.dtos.EditSerialDTO;

import java.util.List;

public interface AdminService {
    void addMovie(AddMovieDTO addMovieDTO);

    List<Movie> findAllMovies();

    EditMovieDTO findMovieById(Long id);

    void save(EditMovieDTO movieDTO);

    void deleteMovieById(Long id);

    void addSerial(AddSerialDTO serial);

    List<Serial> findAllSerials();

    EditSerialDTO findSerialById(Long id);

    void save (EditSerialDTO serialDTO);

    void deleteSerialById(Long id);
}
