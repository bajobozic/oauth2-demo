package dev.bajobozic.oauth2resourcesserver.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private final String name;
    private final Type type;

    public enum Type {
        SPORT, NEWS, ENTERTAINMENT, SIENCE, SOCIAL
    }
}
