package krissto87.showyourtopten.services.impl;

import krissto87.showyourtopten.domain.entities.ListPosition;
import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.domain.entities.User;
import krissto87.showyourtopten.domain.repositories.ListPositionRepository;
import krissto87.showyourtopten.domain.repositories.MovieRepository;
import krissto87.showyourtopten.domain.repositories.UserRepository;
import krissto87.showyourtopten.dtos.AddMovieListDTO;
import krissto87.showyourtopten.dtos.EditMovieListDTO;
import krissto87.showyourtopten.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        User user = getUserFromContext();
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

    @Override
    public List<Movie> findUserList() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getByUsername(username);
        List<ListPosition> movieList = user.getMovieList();
        return movieList.stream().map(ListPosition::getMovie).collect(Collectors.toList());

    }

    @Override
    public EditMovieListDTO getMovieList() {
        User user = getUserFromContext();
        List<ListPosition> movieList = user.getMovieList();
        EditMovieListDTO movieListDTO = new EditMovieListDTO();
        movieListDTO.setFirst(movieList.get(0).getMovie().getId());
        movieListDTO.setSecond(movieList.get(1).getMovie().getId());
        movieListDTO.setThird(movieList.get(2).getMovie().getId());
        movieListDTO.setFourth(movieList.get(3).getMovie().getId());
        movieListDTO.setFifth(movieList.get(4).getMovie().getId());
        movieListDTO.setSixth(movieList.get(5).getMovie().getId());
        movieListDTO.setSeventh(movieList.get(6).getMovie().getId());
        movieListDTO.setEight(movieList.get(7).getMovie().getId());
        movieListDTO.setNinth(movieList.get(8).getMovie().getId());
        movieListDTO.setTenth(movieList.get(9).getMovie().getId());
        return movieListDTO;
    }

    @Override
    public void save(EditMovieListDTO movieList) {
        User user = getUserFromContext();
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

    @Override
    public void deleteUserList() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.getByUsername(name);
        user.getMovieList().clear();
        userRepository.save(user);
    }

    private User getUserFromContext() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.getByUsername(name);
    }


    private void addListPosition(User user, Long movieId, Integer pos) {
        Movie movie = movieRepository.getOne(movieId);
        ListPosition position = new ListPosition();
        position.setPosition(pos);
        position.setMovie(movie);
        user.getMovieList().add(position);
    }
}
