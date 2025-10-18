package com.dnnviet.personal.project.CellphoneS.repositories.shipment;

import com.dnnviet.personal.project.CellphoneS.entities.order.Order;
import com.dnnviet.personal.project.CellphoneS.entities.shipment.Shipment;
import com.dnnviet.personal.project.CellphoneS.enums.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Optional<Shipment> findByOrder(Order order);

    List<Shipment> findByDeliveryStatus(DeliveryStatus deliveryStatus);

    List<Shipment> findByDeliveryAddressContainingIgnoreCase(String deliveryAddress);

    List<Shipment> findByShipmentDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
