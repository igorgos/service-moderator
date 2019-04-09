package com.endava.moderator.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.endava.moderator.ServiceModeratorApplication;
import com.endava.moderator.model.QuantityOrder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class QuantityOrderRepositoryTest {
	@Autowired
	private QuantityOrderRepository quantityOrderRepository;
	
	@Test
	public void testCount() {
		long count = quantityOrderRepository.count();
		assertTrue(count == 0L);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testSave() {
		QuantityOrder quantityOrder = new QuantityOrder();
		quantityOrder.setServiceId(1);
		quantityOrder.setCost(BigDecimal.valueOf(5500.20));
		quantityOrder.setQuantity(BigDecimal.valueOf(5.5));
		quantityOrder.setRequestedAt(new Date());
		QuantityOrder savedService = quantityOrderRepository.save(quantityOrder);
		assertTrue(savedService.getId() > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdate() {
		QuantityOrder quantityOrder = quantityOrderRepository.getOne(10L);
		assertNull(quantityOrder.getDeliveredAt());
		quantityOrder.setDeliveredAt(new Date());
		QuantityOrder savedOrder = quantityOrderRepository.save(quantityOrder);
		assertNotNull(savedOrder.getDeliveredAt());
	}
}
