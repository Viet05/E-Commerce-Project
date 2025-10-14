package com.dnnviet.personal.project.CellphoneS.repositories.customer;

import com.dnnviet.personal.project.CellphoneS.entities.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    Customer findByUser_UserId(Long userId);

    List<Customer> findByNameContaining(String name);

    List<Customer> findByPhoneContaining(String phone);

    List<Customer> findByAddressContaining(String address);

    Customer findTopByOrderByCreatedAtDesc();

    List<Customer> findTop10ByOrderByCreatedAtDesc();

    Long countByCreatedAtBetween(java.time.LocalDateTime startDate, java.time.LocalDateTime endDate);
}
