package krissto87.showyourtopten.services;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.entities.Serial;
import krissto87.showyourtopten.dtos.AddMovieDto;
import krissto87.showyourtopten.dtos.AddSerialDto;
import krissto87.showyourtopten.dtos.EditMovieDto;
import krissto87.showyourtopten.dtos.EditSerialDto;

import java.util.List;

public interface AdminService {
    void addMovie(AddMovieDto addMovieDTO);

    List<Movie> findAllMovies();

    EditMovieDto findMovieById(Long id);

    void save(EditMovieDto movieDTO);

    void deleteMovieById(Long id);

    void addSerial(AddSerialDto serial);

    List<Serial> findAllSerials();

    EditSerialDto findSerialById(Long id);

    void save(EditSerialDto serialDTO);

    void deleteSerialById(Long id);
}
