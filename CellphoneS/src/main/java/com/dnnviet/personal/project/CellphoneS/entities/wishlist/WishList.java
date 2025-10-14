package com.dnnviet.personal.project.CellphoneS.entities.wishlist;

import com.dnnviet.personal.project.CellphoneS.entities.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "wish_lists")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_list_id")
    private Long wishListId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @Column(name = "wish_list_name")
    private String wishListName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
