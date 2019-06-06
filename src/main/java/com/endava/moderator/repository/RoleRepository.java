package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.endava.moderator.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
