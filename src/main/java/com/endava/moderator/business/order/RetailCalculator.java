package com.endava.moderator.business.order;

import java.math.BigDecimal;

import com.endava.moderator.business.IOrderCalculator;
import com.endava.moderator.model.RetailOrder;

public class RetailCalculator implements IOrderCalculator<RetailOrder> {
	private Class<RetailOrder> parameterClass = RetailOrder.class;
	private int unitPrice = 23;
	
	@Override
	public BigDecimal calculate(RetailOrder order) {
		BigDecimal retValue = BigDecimal.ZERO;
		retValue = BigDecimal.valueOf(unitPrice * order.getAmount()); 
		return retValue;
	}

	public Class<RetailOrder> getParameterClass() {
		return parameterClass;
	}
}
