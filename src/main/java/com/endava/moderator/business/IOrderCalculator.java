package com.endava.moderator.business;

import java.math.BigDecimal;

import com.endava.moderator.model.IOrder;

public interface IOrderCalculator<T extends IOrder> {
	BigDecimal calculate(T order);
	Class<T> getParameterClass();

}