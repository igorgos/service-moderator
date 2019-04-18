package com.endava.moderator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.endava.moderator.model.order.Order;
import com.endava.moderator.repository.OrderRepository;

@Service
@Scope("session")
public class OrderService {
	
	@Autowired
	private OrderRepository clientRepository;

	public List<Order> findAll() {
		return clientRepository.findAll();
	}

	public Order save(Order client) {
		return clientRepository.save(client);
	}
}
