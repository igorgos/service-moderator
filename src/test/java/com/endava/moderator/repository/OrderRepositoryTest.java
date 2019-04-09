package com.endava.moderator.repository;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.endava.moderator.ServiceModeratorApplication;
import com.endava.moderator.model.Order;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class OrderRepositoryTest {
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void testCount() {
		long count = orderRepository.count();
		assertTrue(count == 0L);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testSave() {
		Order order = new Order();
		order.setServiceId(1);
		order.setCost(BigDecimal.valueOf(200.15));
		Order savedService = orderRepository.save(order);
		assertTrue(savedService.getId() > 0L);
	}
}
