package com.endava.moderator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.endava.moderator.model.Work;
import com.endava.moderator.repository.WorkRepository;

/**
 * Simple service to be used both by the JSF Controller and the Spring MVC
 * Service to demonstrate that they are working together in the same context.
 * 
 * @author Caleb
 */
@Service
@Scope("session")
public class WorkService {
	
	@Autowired
	private WorkRepository workRepository;

	public List<Work> findAll() {
		return workRepository.findAll();
	}

	public Work save(Work work) {
		return workRepository.save(work);
	}
}
