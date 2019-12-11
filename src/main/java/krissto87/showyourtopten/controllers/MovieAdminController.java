package krissto87.showyourtopten.controllers;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieDTO;
import krissto87.showyourtopten.dtos.EditMovieDTO;
import krissto87.showyourtopten.services.impl.DefaultAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        List<Movie> movies = adminService.findAllMovies();
        model.addAttribute("movies", movies);
        return "admin/movies/list";
    }

    @GetMapping("/edit/{id}")
    public String prepareEditMovie(Model model, @PathVariable Long id) {
        EditMovieDTO movie = adminService.findById(id);
        model.addAttribute("movie", movie);
        return "admin/movies/edit";
    }

    @PostMapping("/edit/{id}")
    public String processEditMovie(@ModelAttribute("movie") @Valid EditMovieDTO movie, BindingResult result,
                                   @PathVariable Long id) {
        if (result.hasErrors()) {
            return "admin/movies/edit";
        }
        if (movie != null) {
            adminService.save(movie);
        }
        return "redirect:/admin/movies/all";
    }

    @GetMapping("/delete/{id}")
    public String prepareDeleteMovie(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        return "admin/movies/delete";
    }

    @PostMapping("/delete/{id}")
    public String processDeleteMovie(@PathVariable Long id) {
        adminService.deleteById(id);
        return "redirect:/admin/movies/all";
    }
}
