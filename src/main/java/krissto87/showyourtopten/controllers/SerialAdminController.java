package krissto87.showyourtopten.controllers;

import krissto87.showyourtopten.dtos.AddSerialDTO;
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
@RequestMapping("/admin/serials")
public class SerialAdminController {

    private final DefaultAdminService adminService;

    public SerialAdminController(DefaultAdminService adminService) {
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
        model.addAttribute("serial", new AddSerialDTO());
        return "admin/serials/add";
    }

    @PostMapping("/add")
    public String processAddMovie(@ModelAttribute("serial") @Valid AddSerialDTO serial,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "admin/serials/add";
        }
        adminService.addSerial(serial);
        return "admin/account";
    }
}
