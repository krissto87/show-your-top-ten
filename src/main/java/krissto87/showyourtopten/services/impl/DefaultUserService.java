package krissto87.showyourtopten.services.impl;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.repositories.MovieRepository;
import krissto87.showyourtopten.domain.repositories.SerialRepository;
import krissto87.showyourtopten.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private ModelMapper modelMapper = new ModelMapper();
    private MovieRepository movieRepository;
    private SerialRepository serialRepository;

    public DefaultUserService(MovieRepository movieRepository, SerialRepository serialRepository) {
        this.movieRepository = movieRepository;
        this.serialRepository = serialRepository;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> allFilms = movieRepository.findAll();
        return allFilms;
    }
}
