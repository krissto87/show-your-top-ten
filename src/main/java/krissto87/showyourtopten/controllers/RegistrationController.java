package krissto87.showyourtopten.controllers;

import krissto87.showyourtopten.dtos.RegistrationDataDto;
import krissto87.showyourtopten.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDto());
        return "register/form";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("registrationData")
                                          @Valid RegistrationDataDto registrationData, BindingResult results) {
        if (results.hasErrors()) {
            return "register/form";
        }
        registrationService.register(registrationData);
        return "redirect:/";
    }
}
