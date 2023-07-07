package dev.bajobozic.oauth2client.services;

import org.springframework.web.client.RestTemplate;

import dev.bajobozic.oauth2client.models.User;

public class RestUserService implements UserService {
    private final RestTemplate restTemplate;

    public RestUserService() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public User addUser(User user) {
        restTemplate.postForObject("http://localhost:9000/users", user, User.class);
        return user;
    }

}
