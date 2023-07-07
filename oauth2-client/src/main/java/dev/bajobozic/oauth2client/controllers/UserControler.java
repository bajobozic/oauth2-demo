package dev.bajobozic.oauth2client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.bajobozic.oauth2client.models.User;
import dev.bajobozic.oauth2client.services.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("admin/users")
@RequiredArgsConstructor
public class UserControler {
    private final UserService userService;

    @GetMapping
    String getUser() {
       return "postUser";
    }

    @PostMapping
    String addUser(User user){
        userService.addUser(user);
        return "redirect:/";
    }
}
