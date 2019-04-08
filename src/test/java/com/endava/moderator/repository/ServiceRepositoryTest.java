package com.endava.moderator.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.endava.moderator.CreditSystemApplication;
import com.endava.moderator.model.Service;
import com.endava.moderator.repository.ServiceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CreditSystemApplication.class})
public class ServiceRepositoryTest {
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Test
	public void testCount() {
		long count = serviceRepository.count();
		assertTrue(count == 0L);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testSave() {
		Service service = new Service();
		service.setName("Livrare Pizza");
		service.setDescription("Livrare de la Andy's pizza");
		service.setType("R");
		Service savedService = serviceRepository.save(service);
		assertTrue(savedService.getId() > 0L);
	}
}
