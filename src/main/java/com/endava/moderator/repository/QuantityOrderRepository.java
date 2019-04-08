package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.QuantityOrder;

@Repository
public interface QuantityOrderRepository extends JpaRepository<QuantityOrder, Long> {

}
