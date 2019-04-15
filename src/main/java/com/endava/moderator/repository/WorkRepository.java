package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Integer> {

}
