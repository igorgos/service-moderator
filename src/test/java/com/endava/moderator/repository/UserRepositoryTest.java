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
import com.endava.moderator.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class UserRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testCount() {
		logger.error("Start: ");
		long count = userRepository.count();
		logger.info("Users: {}", count);
		assertTrue(count > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testSave() {
		User user = new User();
		user.setFirstname("Ion");
		user.setLastname("Gorgos");
		user.setUsername("igorgos");
		user.setPassword("1234");
		User savedService = userRepository.save(user);
		assertTrue(savedService.getId() > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testUpdate() {
		User user = userRepository.getOne(36);
		user.setFirstname("Ion");
		user.setLastname("Gorgos");
		user.setUsername("igorgos");
		user.setPassword("1234");
		User savedService = userRepository. save(user);
		assertTrue(savedService.getId() > 0L);
	}
}
