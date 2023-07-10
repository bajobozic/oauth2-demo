package dev.bajobozic.oauth2client.services;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import dev.bajobozic.oauth2client.models.Post;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestPostService implements PostService {
    private RestTemplate restTemplate;

    public RestPostService(String accessToken) {
        this.restTemplate = new RestTemplate();
        log.info("ACCESS TOKEN: " + accessToken);
        if (accessToken != null && !accessToken.isBlank()) {
            restTemplate.getInterceptors().add(getBearerInterceptor(accessToken));
        }
    }

    @Override
    public Iterable<Post> findAll() {
        return Arrays.asList(restTemplate.getForObject("http://localhost:8080/api/posts", Post[].class));
    }

    @Override
    public Post addPost(Post post) {
        restTemplate.postForObject("http://localhost:8080/api/post", post, Post.class);
        return post;
    }

    private ClientHttpRequestInterceptor getBearerInterceptor(String accessToken) {
        ClientHttpRequestInterceptor clientHttpRequestInterceptor = new ClientHttpRequestInterceptor() {

            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                    throws IOException {
                request.getHeaders().add("Authorization", "Bearer " + accessToken);
                return execution.execute(request, body);
            }

        };
        return clientHttpRequestInterceptor;
    }

}
