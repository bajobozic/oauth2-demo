package dev.bajobozic.oauth2resourcesserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.bajobozic.oauth2resourcesserver.entities.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
    
}
