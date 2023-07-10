package dev.bajobozic.oauth2resourcesserver.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PostRequest {

    private final Integer id;
    private final String name;
    private final Type type;

    public enum Type {
        SPORT, NEWS, ENTERTAINMENT, SIENCE, SOCIAL
    }
}
