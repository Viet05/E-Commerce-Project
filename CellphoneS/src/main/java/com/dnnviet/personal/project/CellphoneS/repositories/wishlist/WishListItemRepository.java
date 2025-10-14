package com.dnnviet.personal.project.CellphoneS.repositories.wishlist;

import com.dnnviet.personal.project.CellphoneS.entities.product.Product;
import com.dnnviet.personal.project.CellphoneS.entities.wishlist.WishList;
import com.dnnviet.personal.project.CellphoneS.entities.wishlist.WishListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem, Long> {

    List<WishListItem> findByWishListId(WishList wishList);
    List<WishListItem> findByWishListIdWishListId(Long wishListId);

    List<WishListItem> findByProductId(Product product);
    List<WishListItem> findByProductIdProductId(Long productId);

    Optional<WishListItem> findByWishListIdWishListIdAndProductIdProductId(Long wishListId, Long productId);

    List<WishListItem> findByCreatedAtAfter(LocalDateTime date);
    List<WishListItem> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    Long countByWishListIdWishListId(Long wishListId);

    List<WishListItem> findByWishListIdCustomerIdCustomerId(Long customerId);
    Optional<WishListItem> findByWishListIdCustomerIdCustomerIdAndProductIdProductId(Long customerId, Long productId);
    boolean existsByWishListIdCustomerIdCustomerIdAndProductIdProductId(Long customerId, Long productId);

    void deleteByWishListIdWishListId(Long wishListId);
    void deleteByWishListIdWishListIdAndProductIdProductId(Long wishListId, Long productId);

    @Query("SELECT wli FROM WishListItem wli WHERE DATE(wli.createdAt) = CURRENT_DATE")
    List<WishListItem> findTodayWishListItems();

    @Query("SELECT wli FROM WishListItem wli WHERE YEAR(wli.createdAt) = YEAR(CURRENT_DATE) AND MONTH(wli.createdAt) = MONTH(CURRENT_DATE)")
    List<WishListItem> findThisMonthWishListItems();

    List<WishListItem> findTop10ByOrderByCreatedAtDesc();

    @Query("SELECT wli.productId.productId, COUNT(wli) FROM WishListItem wli GROUP BY wli.productId.productId ORDER BY COUNT(wli) DESC")
    List<Object[]> findMostWishedProducts();

    List<WishListItem> findByWishListIdCustomerIdCustomerIdAndWishListIdWishListName(Long customerId, String wishListName);
}

