package dev.bajobozic.oauth2client.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
   private String username;
   private String password;
   private String fullName;
   private String email; 
}
