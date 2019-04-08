package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
