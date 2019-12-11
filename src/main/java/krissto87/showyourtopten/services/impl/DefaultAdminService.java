package krissto87.showyourtopten.services.impl;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.repositories.MovieRepository;
import krissto87.showyourtopten.dtos.AddMovieDTO;
import krissto87.showyourtopten.services.AdminService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Movie findById(Long id) {
        Optional<Movie> result = movieRepository.findById(id);
        Movie movie = result.get();
        return movie ;
    }

    @Override
    public void remove(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

}
