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
import com.endava.moderator.model.RetailOrder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class RetailOrderRepositoryTest {
	@Autowired
	private RetailOrderRepository retailOrderRepository;
	
	@Test
	public void testCount() {
		long count = retailOrderRepository.count();
		assertTrue(count == 0L);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testSave() {
		RetailOrder retailOrder = new RetailOrder();
		retailOrder.setServiceId(1);
		retailOrder.setCost(BigDecimal.valueOf(4400.20));
		retailOrder.setAmount(4);
		retailOrder.setRequestedAt(new Date());
		RetailOrder savedService = retailOrderRepository.save(retailOrder);
		assertTrue(savedService.getId() > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdate() {
		RetailOrder retailOrder = retailOrderRepository.getOne(9L);
		assertNull(retailOrder.getDeliveredAt());
		retailOrder.setDeliveredAt(new Date());
		RetailOrder savedOrder = retailOrderRepository.save(retailOrder);
		assertNotNull(savedOrder.getDeliveredAt());
	}
}
