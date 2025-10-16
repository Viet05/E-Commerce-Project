package com.dnnviet.personal.project.CellphoneS.repositories.order;

import com.dnnviet.personal.project.CellphoneS.entities.order.Order;
import com.dnnviet.personal.project.CellphoneS.entities.order.OrderItem;
import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Order orderId);

    List<OrderItem> findByProductId(Product productId);

    List<OrderItem> findByQuantityBetween(Integer minQuantity, Integer maxQuantity);

    List<OrderItem> findByPriceBetween(Double minPrice, Double maxPrice);

}
