package com.dnnviet.personal.project.CellphoneS.entities.user;


import com.dnnviet.personal.project.CellphoneS.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "users",
        indexes = @Index(name = "idx_users_username", columnList = "username", unique = true)
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false) // BCrypt ~60 ký tự
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Version
    private Long version; // optimistic locking (tuỳ)

}
