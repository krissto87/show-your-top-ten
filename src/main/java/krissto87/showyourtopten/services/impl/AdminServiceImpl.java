package krissto87.showyourtopten.services.impl;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.entities.Serial;
import krissto87.showyourtopten.domain.repositories.MovieRepository;
import krissto87.showyourtopten.domain.repositories.SerialRepository;
import krissto87.showyourtopten.dtos.AddMovieDto;
import krissto87.showyourtopten.dtos.AddSerialDto;
import krissto87.showyourtopten.dtos.EditMovieDto;
import krissto87.showyourtopten.dtos.EditSerialDto;
import krissto87.showyourtopten.services.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private ModelMapper mapper = new ModelMapper();
    private MovieRepository movieRepository;
    private SerialRepository serialRepository;

    public AdminServiceImpl(MovieRepository movieRepository, SerialRepository serialRepository) {
        this.movieRepository = movieRepository;
        this.serialRepository = serialRepository;
    }

    @Override
    public void addMovie(AddMovieDto addMovieDTO) {
        Movie movie = mapper.map(addMovieDTO, Movie.class);
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public EditMovieDto findMovieById(Long id) {
        Optional<Movie> result = movieRepository.findById(id);
        Movie movie = result.get();
        EditMovieDto movieDTO = mapper.map(movie, EditMovieDto.class);
        return movieDTO;
    }

    @Override
    public void save(EditMovieDto movieDTO) {
        Movie movie = mapper.map(movieDTO, Movie.class);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void addSerial(AddSerialDto addSerialDTO) {
        Serial serial = mapper.map(addSerialDTO, Serial.class);
        serialRepository.save(serial);
    }

    @Override
    public List<Serial> findAllSerials() {
        return serialRepository.findAll();
    }

    @Override
    public EditSerialDto findSerialById(Long id) {
        Optional<Serial> result = serialRepository.findById(id);
        Serial serial = result.get();
        EditSerialDto serialDTO = mapper.map(serial, EditSerialDto.class);
        return serialDTO;
    }

    @Override
    public void save(EditSerialDto serialDTO) {
        Serial serial = mapper.map(serialDTO, Serial.class);
        serialRepository.save(serial);
    }

    @Override
    public void deleteSerialById(Long id) {
        serialRepository.deleteById(id);
    }
}
