package krissto87.showyourtopten.services.impl;

import krissto87.showyourtopten.domain.entities.ListPosition;
import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.entities.User;
import krissto87.showyourtopten.domain.repositories.ListPositionRepository;
import krissto87.showyourtopten.domain.repositories.MovieRepository;
import krissto87.showyourtopten.domain.repositories.UserRepository;
import krissto87.showyourtopten.dtos.AddMovieListDTO;
import krissto87.showyourtopten.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultUserService implements UserService {

    private ModelMapper mapper = new ModelMapper();
    private MovieRepository movieRepository;
    private UserRepository userRepository;
    private ListPositionRepository listPositionRepository;

    public DefaultUserService(MovieRepository movieRepository, UserRepository userRepository, ListPositionRepository listPositionRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
        this.listPositionRepository = listPositionRepository;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> allFilms = movieRepository.findAll();
        return allFilms;
    }

    @Override
    public void addMovieList(AddMovieListDTO movieList) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getByUsername(username);
        user.getMovieList().clear();

        addListPosition(user, movieList.getFirst(), 1);
        addListPosition(user, movieList.getSecond(), 2);
        addListPosition(user, movieList.getThird(), 3);
        addListPosition(user, movieList.getFourth(), 4);
        addListPosition(user, movieList.getFifth(), 5);
        addListPosition(user, movieList.getSixth(), 6);
        addListPosition(user, movieList.getSeventh(), 7);
        addListPosition(user, movieList.getEight(), 8);
        addListPosition(user, movieList.getNinth(), 9);
        addListPosition(user, movieList.getTenth(), 10);

        ListPosition listPosition = mapper.map(movieList, ListPosition.class);
        listPositionRepository.save(listPosition);
    }

    private void addListPosition(User user, Long movieId, Integer pos) {
        Movie movie = movieRepository.getOne(movieId);
        ListPosition position = new ListPosition();
        position.setPosition(pos);
        position.setMovie(movie);
        user.getMovieList().add(position);
    }
}
