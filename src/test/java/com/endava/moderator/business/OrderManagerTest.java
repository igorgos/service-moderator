package com.endava.moderator.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.endava.moderator.ServiceModeratorApplication;
import com.endava.moderator.model.RetailOrder;
import com.endava.moderator.model.Work;
import com.endava.moderator.model.TimeOrder;
import com.endava.moderator.repository.RetailOrderRepository;
import com.endava.moderator.repository.TimeOrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class OrderManagerTest {
	@Autowired
	private OrderManager orderManager;

	@Autowired
	private RetailOrderRepository retailOrderRepository;

	@Autowired
	private TimeOrderRepository timeOrderRepository;

	@Test
	public void testOrderManager() {
		assertNotNull(orderManager);
	}
	
	@Test
	public void testGetServiceById() {
		Work service = orderManager.getService(1);	
		assertNotNull(service);
		assertEquals(Integer.valueOf(1), service.getId());
	}
	
//	@Test
//	public void testCalculate() {
//		Optional<RetailOrder> retailOrder = retailOrderRepository.findById(2L);
//		BigDecimal cost = orderManager.calculate(retailOrder.get());
//		assertNotNull(cost);
//		assertEquals(BigDecimal.valueOf(92), cost);
//		
//		Optional<TimeOrder> timeOrder = timeOrderRepository.findById(3L);
//		cost = orderManager.calculate(timeOrder.get());
//		assertNotNull(cost);
//		assertEquals(BigDecimal.valueOf(100), cost);
//
//	}

	@Test
	public void testCalculateNewOrder() {
		RetailOrder order = new RetailOrder();
		order.setAmount(10);
		BigDecimal cost = orderManager.calculate(order);
		assertNotNull(cost);
		assertEquals(BigDecimal.valueOf(230), cost);

	}
}
