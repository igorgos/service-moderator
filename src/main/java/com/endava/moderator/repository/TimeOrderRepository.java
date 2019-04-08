package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.TimeOrder;

@Repository
public interface TimeOrderRepository extends JpaRepository<TimeOrder, Long> {

}
