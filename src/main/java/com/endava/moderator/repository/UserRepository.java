package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
