package dev.bajobozic.oauth2client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.bajobozic.oauth2client.models.User;
import dev.bajobozic.oauth2client.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register")
@CrossOrigin(origins = "/**")
@RequiredArgsConstructor
public class UserControler {
    private final UserService userService;

    @GetMapping
    public String getUser() {
        log.info("OPEN ADMIN GET");
        return "registration";
    }

    @PostMapping
    public String addUser(User user) {
        log.info(user.toString());
        userService.addUser(user);
        return "redirect:/";
    }
}
