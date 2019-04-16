package com.endava.moderator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.endava.moderator.model.Client;
import com.endava.moderator.repository.ClientRepository;

@Service
@Scope("session")
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client save(Client client) {
		return clientRepository.save(client);
	}
}
