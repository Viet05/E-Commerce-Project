package com.dnnviet.personal.project.CellphoneS.repositories.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryNameIgnoreCase(String categoryName);

    List<Category> findByCategoryNameContainingIgnoreCase(String categoryName);

    boolean existsByCategoryNameIgnoreCase(String categoryName);

    List<Category> findByCreatedAtAfter(LocalDateTime date);

    List<Category> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

}
