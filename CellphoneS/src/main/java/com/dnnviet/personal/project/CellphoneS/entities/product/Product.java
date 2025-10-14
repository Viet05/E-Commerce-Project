package com.dnnviet.personal.project.CellphoneS.entities.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.0")
    private double price;

    @Column(name = "stock_quantity", nullable = false)
    @Min(value = 0)
    private int stockQuantity;

    @Column(name = "brand")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoryId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}
