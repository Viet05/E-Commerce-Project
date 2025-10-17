package com.dnnviet.personal.project.CellphoneS.entities.user;


import com.dnnviet.personal.project.CellphoneS.entities.cart.Cart;
import com.dnnviet.personal.project.CellphoneS.entities.cart.CartItem;
import com.dnnviet.personal.project.CellphoneS.entities.order.Order;
import com.dnnviet.personal.project.CellphoneS.entities.wishlist.WishList;
import com.dnnviet.personal.project.CellphoneS.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    @Column(name =  "email")
    private String email;

    @Column(nullable = false) // BCrypt ~60 ký tự
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<WishList> wishLists;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Version
    private Long version; // optimistic locking (tuỳ)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
