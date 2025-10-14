package com.dnnviet.personal.project.CellphoneS.repositories.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.Category;
import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    boolean existsByName(String name);

    List<Product> findByBrand(String brand);

    boolean existsByBrand(String brand);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Product> findByCategoryId(Category category);

    List<Product> findByCategoryId_CategoryId(Long categoryId);

    List<Product> findByStockQuantityGreaterThan(Integer quantity);

    List<Product> findByStockQuantityLessThanEqual(Integer quantity);

    List<Product> findByStockQuantity(Integer quantity);

    List<Product> findByPriceLessThanEqual(Double maxPrice);

    List<Product> findByPriceGreaterThanEqual(Double minPrice);

    List<Product> findByNameContainingIgnoreCaseAndBrand(String name, String brand);

    List<Product> findByCategoryIdAndPriceBetween(Category category, Double minPrice, Double maxPrice);

    List<Product> findByCreatedAtAfter(LocalDateTime date);
}
