package com.javaschoolshop.dao;

import com.javaschoolshop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.*;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("SELECT oi.productId, oi.imageUrl, SUM(oi.quantity) AS totalQuantity " +
            "FROM OrderItem oi " +
            "GROUP BY oi.productId, oi.imageUrl " +
            "ORDER BY totalQuantity DESC")
    List<Object[]> findProductQuantitiesOrderByTotalQuantityDesc();


    @Query("SELECT oi FROM Usuario u JOIN Customer c ON c.email = u.email JOIN Order o ON o.customer.id = c.id JOIN OrderItem oi ON oi.order.id = o.id WHERE u.email = :email")
    List<OrderItem> getOrderItemsByEmail(@Param("email") String email);

}
