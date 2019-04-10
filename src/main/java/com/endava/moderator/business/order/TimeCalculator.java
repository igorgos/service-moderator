package com.endava.moderator.business.order;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import com.endava.moderator.model.TimeOrder;

public class TimeCalculator implements IOrderCalculator<TimeOrder> {
	private Class<TimeOrder> parameterClass = TimeOrder.class;
	int unitPrice = 100;
	
	@Override
	public BigDecimal calculate(TimeOrder order) {
		BigDecimal retValue = BigDecimal.ZERO;
		long hoursBetween = ChronoUnit.HOURS.between(order.getStartAt().toInstant(), order.getEndAt().toInstant());
		retValue = BigDecimal.valueOf(unitPrice * (hoursBetween + 1)); 
		return retValue;
	}

	@Override
	public Class<TimeOrder> getParameterClass() {
		return parameterClass;
	}
}
