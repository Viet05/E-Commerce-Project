package com.dnnviet.personal.project.CellphoneS.repositories.user;

import com.dnnviet.personal.project.CellphoneS.entities.user.User;
import com.dnnviet.personal.project.CellphoneS.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(String username);

    boolean existsByUsernameIgnoreCase(String username);

    List<User> findByRole(Role role);

    Long countByRole(Role role);

    List<User> findByCreatedAtAfter(LocalDateTime date);

    Optional<User> findTopByOrderByCreatedAtDesc();

    @Query("SELECT COUNT(u) FROM User u WHERE DATE(u.createdAt) = CURRENT_DATE")
    Long countTodayUsers();
}

