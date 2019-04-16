package com.endava.moderator.utils;

import java.util.Map;

import org.junit.Test;

import com.endava.moderator.business.order.IOrderCalculator;
import com.endava.moderator.model.order.IOrder;

public class OrderCollectionFactoryTest {
	
	@Test
	public void testMain() {
		Map<String, IOrderCalculator<IOrder>> a = null;
		try {
			a = OrderCollectionFactory.getChargeInstructionMap();
			int i=1;
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
