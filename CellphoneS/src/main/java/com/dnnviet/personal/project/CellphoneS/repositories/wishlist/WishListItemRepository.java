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

   List<WishListItem> findByWishListId(WishList WishListId);

   List<WishListItem> findByProductId(Product ProductId);
}

