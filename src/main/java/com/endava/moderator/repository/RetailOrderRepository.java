package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.RetailOrder;

@Repository
public interface RetailOrderRepository extends JpaRepository<RetailOrder, Long> {

}
