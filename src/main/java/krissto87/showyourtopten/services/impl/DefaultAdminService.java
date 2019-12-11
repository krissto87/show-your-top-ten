package krissto87.showyourtopten.services.impl;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.repositories.MovieRepository;
import krissto87.showyourtopten.dtos.AddMovieDTO;
import krissto87.showyourtopten.services.AdminService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultAdminService implements AdminService {

    private MovieRepository movieRepository;

    public DefaultAdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void addMovie(AddMovieDTO addMovieDTO) {
        ModelMapper mapper = new ModelMapper();
        Movie movie = mapper.map(addMovieDTO, Movie.class);
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
