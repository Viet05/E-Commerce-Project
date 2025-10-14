package com.dnnviet.personal.project.CellphoneS.repositories.wishlist;

import com.dnnviet.personal.project.CellphoneS.entities.customer.Customer;
import com.dnnviet.personal.project.CellphoneS.entities.wishlist.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

    List<WishList> findByCustomerId(Customer customer);

    List<WishList> findByCustomerId_CustomerId(Long customerId);

    Optional<WishList> findByCustomerId_CustomerIdAndWishListName(Long customerId, String wishListName);

    List<WishList> findByWishListNameContaining(String wishListName);

    List<WishList> findByWishListName(String wishListName);

    boolean existsByCustomerId_CustomerIdAndWishListName(Long customerId, String wishListName);

    List<WishList> findByCreatedAtAfter(LocalDateTime date);

    List<WishList> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    Optional<WishList> findTopByCustomerId_CustomerIdOrderByCreatedAtDesc(Long customerId);

    Long countByCustomerId_CustomerId(Long customerId);

    Long countByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    void deleteByCustomerId_CustomerId(Long customerId);
}
