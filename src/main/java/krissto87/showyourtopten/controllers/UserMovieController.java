package krissto87.showyourtopten.controllers;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieListDTO;
import krissto87.showyourtopten.services.impl.DefaultUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user/movies")
public class UserMovieController {

    private final DefaultUserService userService;

    public UserMovieController(DefaultUserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("movies")
    public List<Movie> getAllMovies(Model model) {
        List<Movie> movies = userService.findAll();
        model.addAttribute("movies", movies);
        return movies;
    }

    @GetMapping("/add")
    public String prepareAddUserMovieList(Model model) {
        model.addAttribute("movieList", new AddMovieListDTO());
        return "user/movies/add";
    }

    @PostMapping("/add")
    public String processAddUserMovieList(@ModelAttribute("movieList") @Valid AddMovieListDTO movieList,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return "user/movies/add";
        }
        userService.addMovieList(movieList);
        return "user/account";
    }

    @GetMapping("/details")
    public String prepareMyListMovie(Model model) {
        List<Movie> userMovies = userService.findUserList();
        model.addAttribute("userMovies", userMovies);
        return "user/movies/details";
    }
}
