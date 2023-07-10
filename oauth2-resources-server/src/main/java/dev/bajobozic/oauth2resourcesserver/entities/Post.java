package dev.bajobozic.oauth2resourcesserver.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Type type;

    public enum Type {
        SPORT, NEWS, ENTERTAINMENT, SIENCE, SOCIAL
    }
}
