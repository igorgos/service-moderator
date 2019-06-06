package com.endava.moderator.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.endava.moderator.business.order.IOrderCalculator;
import com.endava.moderator.model.order.IOrder;

public class OrderCollectionFactoryTest {
	
	@Test
	public void testOrderMap() throws ServiceException {
		Map<String, IOrderCalculator<IOrder>> instructions = OrderCollectionFactory.getOrderMap();
		assertNotNull(instructions);
		assertEquals(3, instructions.size());
	}
}
