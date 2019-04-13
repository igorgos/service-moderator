package com.endava.moderator.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

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
import com.endava.moderator.model.IOrder;
import com.endava.moderator.model.Order;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class OrderRepositoryTest {
	private static Logger logger = LoggerFactory.getLogger(OrderRepositoryTest.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void testCount() {
		long count = orderRepository.count();
		logger.info("Orders: {}", count);
		assertTrue(count > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testSave() {
		Order order = new Order();
		order.setServiceId(1);
		order.setCost(BigDecimal.valueOf(200.15));
		IOrder savedService = orderRepository.save(order);
		assertTrue(savedService.getId() > 0L);
	}

	@Test
	public void testFindById() {
		IOrder order = orderRepository.getByIdLazy(1L);
		assertTrue(order.getId() == 1L);
		assertNotNull(order.getService());
		assertEquals("Q", order.getService().getType());
	}
}
