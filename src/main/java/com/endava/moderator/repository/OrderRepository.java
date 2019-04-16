package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.order.IOrder;
import com.endava.moderator.model.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
    @Query("SELECT orderEntity FROM Order orderEntity " +
    		"JOIN FETCH orderEntity.service " +
            "WHERE orderEntity.id = :orderId")
    IOrder getByIdLazy(@Param("orderId") Long id);
}
