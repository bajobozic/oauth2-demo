package dev.bajobozic.oauth2authorizationserever.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.bajobozic.oauth2authorizationserever.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
