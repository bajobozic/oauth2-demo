package dev.bajobozic.oauth2client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    String home() {
        log.info("Home page");
        return "home";
    }
}
