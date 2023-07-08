package dev.bajobozic.oauth2client.services;

import dev.bajobozic.oauth2client.models.Post;

public interface PostService {
    Iterable<Post> findAll();

    Post addPost(Post post);
}
