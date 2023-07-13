package dev.bajobozic.oauth2authorizationserever.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.bajobozic.oauth2authorizationserever.dto.UserDao;
import dev.bajobozic.oauth2authorizationserever.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SaveUserControler {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    @ResponseStatus(value = HttpStatus.CREATED)
    UserDao addUser(@RequestBody UserDao userDao) {
        var user = userDao.toUser(passwordEncoder);
        userRepository.save(user);
        return userDao;
    }
}
