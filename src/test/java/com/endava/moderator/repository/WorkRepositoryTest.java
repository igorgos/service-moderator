package com.endava.moderator.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.endava.moderator.ServiceModeratorApplication;
import com.endava.moderator.model.Work;
import com.endava.moderator.repository.WorkRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class WorkRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(WorkRepositoryTest.class);
	@Autowired
	private WorkRepository serviceRepository;

	@Test
	public void testCount() {
		logger.error("Start: ");
		long count = serviceRepository.count();
		logger.info("Services: {}", count);
		assertTrue(count > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testSave() {
		Work service = new Work();
		service.setName("Livrare Flori");
		service.setDescription("Livrare flori de la parcul catedralei");
		service.setType("R");
		Work savedService = serviceRepository.save(service);
		assertTrue(savedService.getId() > 0L);
	}
}
