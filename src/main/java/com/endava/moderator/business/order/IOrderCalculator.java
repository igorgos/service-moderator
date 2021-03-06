package com.endava.moderator.business.order;

import java.math.BigDecimal;

import com.endava.moderator.model.order.IOrder;

public interface IOrderCalculator<T extends IOrder> {
	Class<T> getParameterClass();
	BigDecimal calculate(T order);
}
