package dev.bajobozic.oauth2authorizationserever.dto;

import java.util.HashSet;

import org.springframework.security.crypto.password.PasswordEncoder;

import dev.bajobozic.oauth2authorizationserever.entities.Authority;
import dev.bajobozic.oauth2authorizationserever.entities.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Data
public class UserDao {
   private final String username;
   private final String password;
   private final String fullName;
   private final String email;

   public User toUser(PasswordEncoder passwordEncoder) {
      var user = new User();
      user.setUsername(username);
      user.setPassword(passwordEncoder.encode(password));
      user.setFullName(fullName);
      user.setEmail(email);
      var authorities = new HashSet<Authority>() {
         {
            add(new Authority("write"));
            add(new Authority("delete"));

         }
      };
      user.setAuthorities(authorities);
      return user;
   }
}
