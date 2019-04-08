package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
