package krissto87.showyourtopten.controllers;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieDTO;
import krissto87.showyourtopten.services.impl.DefaultAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/movies")
public class MovieAdminController {

    private final DefaultAdminService adminService;

    public MovieAdminController(DefaultAdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("types")
    public List<String> getTypes() {
        String[] movieTypes = new String[]{"Action", "Adventure", "Comedy",
                "Drama", "Fantasy", "Historical", "Crime", "Thriller"};
        return Arrays.asList(movieTypes);
    }

    @GetMapping("/add")
    public String prepareAddMovie(Model model) {
        model.addAttribute("movie", new AddMovieDTO());
        return "admin/movies/add";
    }

    @PostMapping("/add")
    public String processAddMovie(@ModelAttribute("movie") @Valid AddMovieDTO movie,
                                           BindingResult result) {
        if (result.hasErrors()) {
            return "admin/movies/add";
        }
        adminService.addMovie(movie);
        return "admin/account";
    }

    @GetMapping("/all")
    public String prepareAllMoviePage(Model model) {
        List<Movie> movies = adminService.findAll();
        model.addAttribute("movies", movies);
        return "admin/movies/list";
    }
}
