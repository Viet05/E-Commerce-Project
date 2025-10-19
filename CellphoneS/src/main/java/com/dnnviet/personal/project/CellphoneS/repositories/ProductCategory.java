package com.dnnviet.personal.project.CellphoneS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategory extends JpaRepository<ProductCategory, Long> {
}
