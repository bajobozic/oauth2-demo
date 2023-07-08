package dev.bajobozic.oauth2client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.context.annotation.RequestScope;

import dev.bajobozic.oauth2client.services.PostService;
import dev.bajobozic.oauth2client.services.RestPostService;
import dev.bajobozic.oauth2client.services.RestUserService;
import dev.bajobozic.oauth2client.services.UserService;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers("/", "/register").permitAll()
                .anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults())
                .oauth2Client(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    @RequestScope
    PostService postService(OAuth2AuthorizedClientService clientService) {
        String accessToken = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            String authorizedClientRegistrationId = oAuth2AuthenticationToken.getAuthorizedClientRegistrationId();
            if (authorizedClientRegistrationId.equals("demo-client")) {
                OAuth2AuthorizedClient authorizedClient = clientService.loadAuthorizedClient(
                        authorizedClientRegistrationId, oAuth2AuthenticationToken.getPrincipal().getName());
                accessToken = authorizedClient.getAccessToken().getTokenValue();
            }
        }
        return new RestPostService(accessToken);
    }

    @Bean
    UserService userService() {
        return new RestUserService();
    }
}
