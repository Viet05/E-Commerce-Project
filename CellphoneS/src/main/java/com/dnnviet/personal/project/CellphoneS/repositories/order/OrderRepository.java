package com.dnnviet.personal.project.CellphoneS.repositories.order;

import com.dnnviet.personal.project.CellphoneS.entities.customer.Customer;
import com.dnnviet.personal.project.CellphoneS.entities.order.Order;
import com.dnnviet.personal.project.CellphoneS.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrdersByCustomerId(Customer customerId);

    Optional<Order> findByOrderId(Long id);

    Optional<Order> findByStatus(OrderStatus status);

    List<Order> findByOrderDateBetween(LocalDateTime from, LocalDateTime to);

}
