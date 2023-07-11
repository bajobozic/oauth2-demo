package dev.bajobozic.oauth2authorizationserever.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.bajobozic.oauth2authorizationserever.model.UserDao;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SaveUserControler {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    @ResponseStatus(value = HttpStatus.CREATED)
    UserDao addUser(@RequestBody UserDao user) {
        if (userDetailsService.getClass().isAssignableFrom(InMemoryUserDetailsManager.class)) {
            InMemoryUserDetailsManager inMemoryUserDetailsManager = (InMemoryUserDetailsManager) userDetailsService;
            inMemoryUserDetailsManager.createUser(User.withUsername(user.getUsername())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .authorities("write", "delete")
                    .build());
        }
        return user;
    }
}
