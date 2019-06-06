package com.endava.moderator.business.order;

import java.math.BigDecimal;

import com.endava.moderator.model.order.QuantityOrder;

public class QuantityCalculator implements IOrderCalculator<QuantityOrder> {
	private Class<QuantityOrder> parameterClass = QuantityOrder.class;
	int unitPrice = 23;
	
	@Override
	public BigDecimal calculate(QuantityOrder order) {
		BigDecimal retValue = BigDecimal.ZERO;
		retValue = BigDecimal.valueOf(unitPrice * order.getQuantity().doubleValue()); 
		return retValue;
	}

	@Override
	public Class<QuantityOrder> getParameterClass() {
		return parameterClass;
	}
}
