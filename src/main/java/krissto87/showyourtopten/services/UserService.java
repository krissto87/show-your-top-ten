package krissto87.showyourtopten.services;

import krissto87.showyourtopten.domain.entities.Movie;

import java.util.List;

public interface UserService {
    List<Movie> findAll();
}
