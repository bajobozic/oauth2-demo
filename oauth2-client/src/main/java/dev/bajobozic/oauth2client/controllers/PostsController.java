package dev.bajobozic.oauth2client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.bajobozic.oauth2client.models.Post;
import dev.bajobozic.oauth2client.services.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/posts")
@RequiredArgsConstructor
public class PostsController {
    private final PostService postService;

    @GetMapping
    String postsAdmin(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "postAdmin";
    }

    @PostMapping
    String addPost(Post post) {
        log.info(post.toString());
        postService.addPost(post);
        return "redirect:/admin/posts";
    }
}
