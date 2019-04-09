package com.endava.moderator.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endava.moderator.repository.ServiceRepository;

@Service
public class OrderManager {
	@Autowired
	private ServiceRepository serviceRepository;
	
	public com.endava.moderator.model.Service getService(Integer id) {
		return serviceRepository.getOne(id);
	}
	

}
