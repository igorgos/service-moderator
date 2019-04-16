package com.endava.moderator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.endava.moderator.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
