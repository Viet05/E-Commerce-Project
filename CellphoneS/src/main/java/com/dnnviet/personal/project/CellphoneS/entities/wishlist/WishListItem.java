package com.dnnviet.personal.project.CellphoneS.entities.wishlist;

import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "wish_list_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishListItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wish_list_item_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "wish_list_id", nullable = false)
    private WishList wishListId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

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
