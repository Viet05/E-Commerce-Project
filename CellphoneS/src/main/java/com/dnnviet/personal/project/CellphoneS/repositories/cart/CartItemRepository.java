package com.dnnviet.personal.project.CellphoneS.repositories.cart;

import com.dnnviet.personal.project.CellphoneS.entities.cart.Cart;
import com.dnnviet.personal.project.CellphoneS.entities.cart.CartItem;
import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findCartItemByCart(Cart cartId);  // Tìm các mặt hàng trong giỏ hàng theo cartId

    Optional<CartItem> findByCartAndProducts(Cart cartId, Product productId);
}
