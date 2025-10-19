package com.dnnviet.personal.project.CellphoneS.repositories.store;

import com.dnnviet.personal.project.CellphoneS.entities.store.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long> {
}
