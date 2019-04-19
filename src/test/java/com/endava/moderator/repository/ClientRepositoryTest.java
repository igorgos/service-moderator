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
import com.endava.moderator.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class ClientRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(ClientRepositoryTest.class);
	@Autowired
	private ClientRepository clientRepository;

	@Test
	public void testCount() {
		logger.error("Start: ");
		long count = clientRepository.count();
		logger.info("Clients: {}", count);
		assertTrue(count > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testSave() {
		Client client = new Client();
		client.setName("Garofița");
		client.setDescription("Livrare flori de la parcul catedralei");
		Client savedClient = clientRepository.save(client);
		assertTrue(savedClient.getId() > 0L);
	}
}
