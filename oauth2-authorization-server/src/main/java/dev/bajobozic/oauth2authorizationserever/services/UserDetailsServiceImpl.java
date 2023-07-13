package dev.bajobozic.oauth2authorizationserever.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.bajobozic.oauth2authorizationserever.model.UserDetailsImpl;
import dev.bajobozic.oauth2authorizationserever.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(":("));
        return new UserDetailsImpl(user);
    }

}
