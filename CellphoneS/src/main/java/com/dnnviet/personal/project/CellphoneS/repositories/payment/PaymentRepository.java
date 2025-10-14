package com.dnnviet.personal.project.CellphoneS.repositories.payment;

import com.dnnviet.personal.project.CellphoneS.entities.order.Order;
import com.dnnviet.personal.project.CellphoneS.entities.payment.Payment;
import com.dnnviet.personal.project.CellphoneS.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> getPaymentsByStatus(PaymentStatus status);
    List<Payment> getPaymentByOrderId(Order orderId);
    boolean existsByOrderId(Order orderId);
    List<Payment> findByAmountBetween(Double minAmount, Double maxAmount);

}
