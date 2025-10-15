package com.dnnviet.personal.project.CellphoneS.repositories.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.Category;
import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductId(Long productId);

    Optional<Product> findByName(String productName);

    List<Product> findByCategoryId(Category categoryId);

    List<Product> findByBrand(String brand);

    List<Product> findByPriceBetween(Double lower, Double higher);

    List<Product> findByStockQuantity(Integer stockQuantity);
}
