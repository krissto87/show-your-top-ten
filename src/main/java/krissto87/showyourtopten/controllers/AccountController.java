package krissto87.showyourtopten.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class AccountController {

    @GetMapping
    public String prepareAccountPage(Principal principal) {
        String username = principal.getName(); //majac username mamy dostep do wszystkiego (nie szukamy po id)
        return "/user/account";
    }
}
