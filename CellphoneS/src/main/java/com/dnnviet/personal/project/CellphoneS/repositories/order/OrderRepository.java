package com.dnnviet.personal.project.CellphoneS.repositories.order;

import com.dnnviet.personal.project.CellphoneS.entities.order.Order;
import com.dnnviet.personal.project.CellphoneS.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // ======== FIND BY RELATIONS ========

    // Tìm đơn hàng theo customerId
    List<Order> findByCustomerId_CustomerId(Long customerId);

    // Tìm đơn hàng theo trạng thái
    List<Order> findByStatus(OrderStatus orderStatus);

    // Tìm đơn hàng theo customerId và trạng thái
    List<Order> findByCustomerId_CustomerIdAndStatus(Long customerId, OrderStatus orderStatus);

    // Tìm đơn hàng trong khoảng thời gian
    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Tìm đơn hàng sau ngày nhất định
    List<Order> findByOrderDateAfter(LocalDateTime date);

    // Tìm đơn hàng trước ngày nhất định
    List<Order> findByOrderDateBefore(LocalDateTime date);

    // Tìm đơn hàng trong khoảng tổng tiền
    List<Order> findByTotalAmountBetween(Double minAmount, Double maxAmount);

    // Tìm đơn hàng có tổng tiền lớn hơn hoặc bằng giá trị nhất định
    List<Order> findByTotalAmountGreaterThanEqual(Double minAmount);

    // Tìm đơn hàng có tổng tiền nhỏ hơn hoặc bằng giá trị nhất định
    List<Order> findByTotalAmountLessThanEqual(Double maxAmount);

    // Tìm đơn hàng mới nhất của một khách hàng
    Optional<Order> findTopByCustomerId_CustomerIdOrderByOrderDateDesc(Long customerId);

    Long countByStatus(OrderStatus orderStatus);

    // Đếm số lượng đơn hàng của khách hàng
    Long countByCustomerId_CustomerId(Long customerId);

    // ======== SPECIAL QUERIES ========

    // Tìm đơn hàng được tạo trong ngày
    @Query("SELECT o FROM Order o WHERE o.orderDate >= CURRENT_DATE")
    List<Order> findTodayOrders();

    // Tìm đơn hàng được tạo trong tuần
    @Query("SELECT o FROM Order o WHERE o.orderDate >= :startOfWeek")
    List<Order> findThisWeekOrders(@Param("startOfWeek") LocalDateTime startOfWeek);

    // Tìm đơn hàng được tạo trong tháng
    @Query("SELECT o FROM Order o WHERE YEAR(o.orderDate) = YEAR(CURRENT_DATE) AND MONTH(o.orderDate) = MONTH(CURRENT_DATE)")
    List<Order> findThisMonthOrders();

    // Tìm khách hàng top theo số lượng đơn hàng
    @Query("SELECT o.customerId.customerId, COUNT(o) FROM Order o GROUP BY o.customerId.customerId ORDER BY COUNT(o) DESC")
    List<Object[]> findTopCustomersByOrderCount(@Param("limit") int limit);

    // Tính tổng doanh thu trong khoảng thời gian
    @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate AND o.status = 'COMPLETED'")
    Double calculateTotalRevenue(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
