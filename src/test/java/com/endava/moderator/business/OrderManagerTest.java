package com.endava.moderator.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.endava.moderator.ServiceModeratorApplication;
import com.endava.moderator.model.Service;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class OrderManagerTest {
	@Autowired
	private OrderManager orderManager;

	@Test
	public void testOrderManager() {
		assertNotNull(orderManager);
	}
	
	@Test
	public void testGetServiceById() {
		Service service = orderManager.getService(1);	
		assertNotNull(service);
		assertEquals(Integer.valueOf(1), service.getId());
	}
}
