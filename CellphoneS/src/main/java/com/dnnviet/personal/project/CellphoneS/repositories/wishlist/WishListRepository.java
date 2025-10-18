package com.dnnviet.personal.project.CellphoneS.repositories.wishlist;


import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.entities.wishlist.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {

    List<WishList> getAllWishListByUser(User userId);

    Optional<WishList> findByUserAndWishListName(User userId, String wishListName);


}
