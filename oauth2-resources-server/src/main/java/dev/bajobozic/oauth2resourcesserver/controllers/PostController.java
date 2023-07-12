package dev.bajobozic.oauth2resourcesserver.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.bajobozic.oauth2resourcesserver.dto.PostRequest;
import dev.bajobozic.oauth2resourcesserver.dto.PostRequest.Type;
import dev.bajobozic.oauth2resourcesserver.entities.Post;
import dev.bajobozic.oauth2resourcesserver.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api", produces = "application/json")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @GetMapping(path = "/posts")
    ResponseEntity<Iterable<Post>> getAll() {
        List<Post> postList = postRepository.findAll();
        log.info("POST LIST " + postList);
        return ResponseEntity.ok(postList);
    }

    @PostMapping(path = "/post", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PostRequest postMethodName(@RequestBody PostRequest postRequest) {
        Post post = new Post();
        post.setName(postRequest.getName());
        Type postRequestType = postRequest.getType();
        post.setType(Post.Type.valueOf(postRequestType.toString()));
        postRepository.save(post);
        log.info("SAVED POST: " + post.toString());
        return postRequest;
    }

}
