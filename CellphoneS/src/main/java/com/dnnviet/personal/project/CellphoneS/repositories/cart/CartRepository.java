package com.dnnviet.personal.project.CellphoneS.repositories.cart;

import com.dnnviet.personal.project.CellphoneS.entities.cart.Cart;
import com.dnnviet.personal.project.CellphoneS.entities.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByCartId(Long cartId);
    Optional<Cart> findByCustomerId(Customer customerId);
}
