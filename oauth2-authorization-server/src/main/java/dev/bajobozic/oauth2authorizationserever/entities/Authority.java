package dev.bajobozic.oauth2authorizationserever.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Data
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private final String name;
}
