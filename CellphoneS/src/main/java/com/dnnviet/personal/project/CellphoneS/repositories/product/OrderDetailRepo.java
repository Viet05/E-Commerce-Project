package com.dnnviet.personal.project.CellphoneS.repositories.product;

import com.dnnviet.personal.project.CellphoneS.entities.product.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
}
