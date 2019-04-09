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
import com.endava.moderator.model.TimeOrder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class TimeOrderRepositoryTest {
	@Autowired
	private TimeOrderRepository timeOrderRepository;
	
	@Test
	public void testCount() {
		long count = timeOrderRepository.count();
		assertTrue(count > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testSave() {
		TimeOrder timeOrder = new TimeOrder();
		timeOrder.setServiceId(1);
		timeOrder.setCost(BigDecimal.valueOf(4400.20));
		timeOrder.setStartAt(new Date());
		timeOrder.setEndAt(new Date());
		timeOrder.setRequestedAt(new Date());
		TimeOrder savedService = timeOrderRepository.save(timeOrder);
		assertTrue(savedService.getId() > 0L);
	}

	@Test
	@Transactional
	@Rollback(value = true)
	public void testUpdate() {
		TimeOrder timeOrder = timeOrderRepository.getOne(11L);
		assertNull(timeOrder.getDeliveredAt());
		timeOrder.setDeliveredAt(new Date());
		TimeOrder savedOrder = timeOrderRepository.save(timeOrder);
		assertNotNull(savedOrder.getDeliveredAt());
	}
}
