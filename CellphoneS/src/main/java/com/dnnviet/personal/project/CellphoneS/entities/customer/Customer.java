package com.dnnviet.personal.project.CellphoneS.entities.customer;

import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "customers",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_customers_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_customers_user", columnNames = "user_id")
        },
        indexes = {
                @Index(name = "idx_customers_email", columnList = "email")
        }
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(length = 12)
    private String phone;

    @Column(length = 50)
    private String address;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
