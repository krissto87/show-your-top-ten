package krissto87.showyourtopten.controllers;

import krissto87.showyourtopten.domain.entities.Movie;
import krissto87.showyourtopten.dtos.AddMovieDto;
import krissto87.showyourtopten.dtos.EditMovieDto;
import krissto87.showyourtopten.services.impl.AdminServiceImpl;
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

    private final AdminServiceImpl adminService;

    public MovieAdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("types")
    public List<String> getTypes() {
        String[] movieTypes = new String[]{"Action", "Adventure", "Biographical", "Comedy",
                "Drama", "Fantasy", "Historical", "Crime", "Thriller", "Sci-fi"};
        return Arrays.asList(movieTypes);
    }

    @GetMapping("/add")
    public String prepareAddMovie(Model model) {
        model.addAttribute("movie", new AddMovieDto());
        return "admin/movies/add";
    }

    @PostMapping("/add")
    public String processAddMovie(@ModelAttribute("movie") @Valid AddMovieDto movie,
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
        EditMovieDto movie = adminService.findMovieById(id);
        model.addAttribute("movie", movie);
        return "admin/movies/edit";
    }

    @PostMapping("/edit/{id}")
    public String processEditMovie(@ModelAttribute("movie") @Valid EditMovieDto movie, BindingResult result,
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
        adminService.deleteMovieById(id);
        return "redirect:/admin/movies/all";
    }

    @GetMapping("/description/{id}")
    public String movieDescriptionPage(Model model, @PathVariable Long id) {
        EditMovieDto movie = adminService.findMovieById(id);
        model.addAttribute("movie", movie);
        return "admin/movies/description";
    }
}
