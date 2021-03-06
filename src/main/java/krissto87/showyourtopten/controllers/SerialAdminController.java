package krissto87.showyourtopten.controllers;

import krissto87.showyourtopten.domain.entities.Serial;
import krissto87.showyourtopten.dtos.AddSerialDto;
import krissto87.showyourtopten.dtos.EditSerialDto;
import krissto87.showyourtopten.services.impl.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/serials")
public class SerialAdminController {

    private final AdminServiceImpl adminService;

    public SerialAdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("types")
    public List<String> getTypes() {
        String[] movieTypes = new String[]{"Action", "Adventure", "Biographical", "Comedy",
                "Drama", "Fantasy", "Historical", "Crime", "Thriller", "Sci-fi"};
        return Arrays.asList(movieTypes);
    }

    @GetMapping("/add")
    public String prepareAddSerial(Model model) {
        model.addAttribute("serial", new AddSerialDto());
        return "admin/serials/add";
    }

    @PostMapping("/add")
    public String processAddSerial(@ModelAttribute("serial") @Valid AddSerialDto serial,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "admin/serials/add";
        }
        adminService.addSerial(serial);
        return "admin/account";
    }

    @GetMapping("/all")
    public String prepareAllSerialPage(Model model) {
        List<Serial> serials = adminService.findAllSerials();
        model.addAttribute("serials", serials);
        return "admin/serials/list";
    }

    @GetMapping("/edit/{id}")
    public String prepareSerialSerial(Model model, @PathVariable Long id) {
        EditSerialDto serial = adminService.findSerialById(id);
        model.addAttribute("serial", serial);
        return "admin/serials/edit";
    }

    @PostMapping("/edit/{id}")
    public String processEditSerial(@ModelAttribute("serial") @Valid EditSerialDto serial, BindingResult result,
                                    @PathVariable Long id) {
        if (result.hasErrors()) {
            return "admin/serials/edit";
        }
        if (serial != null) {
            adminService.save(serial);
        }
        return "redirect:/admin/serials/all";
    }

    @GetMapping("/delete/{id}")
    public String prepareDeleteSerial(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        return "admin/serials/delete";
    }

    @PostMapping("/delete/{id}")
    public String processDeleteSerial(@PathVariable Long id) {
        adminService.deleteSerialById(id);
        return "redirect:/admin/serials/all";
    }

    @GetMapping("/description/{id}")
    public String serialDescriptionPage(Model model, @PathVariable Long id) {
        EditSerialDto serial = adminService.findSerialById(id);
        model.addAttribute("serial", serial);
        return "admin/serials/description";
    }
}
