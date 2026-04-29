package com.miChat.userAPI.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor // Void constructor is required to JPA
@Entity
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    @NonNull private String name;

    @Column(nullable = false)
    @NonNull private String email;

    @Column(nullable = false)
    @NonNull private String password;

    @Column(nullable = false)
    private boolean active=false;

    @Column(name="create_at")
    @Setter(AccessLevel.PRIVATE)
    private LocalDateTime createAt;

    @PrePersist
    public void defineCreationTime(){
        this.createAt = LocalDateTime.now();
    }
}
