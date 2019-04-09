package com.endava.moderator.business;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endava.moderator.business.cost.IOrderCalculator;
import com.endava.moderator.business.cost.QuantityCalculator;
import com.endava.moderator.business.cost.RetailCalculator;
import com.endava.moderator.business.cost.TimeCalculator;
import com.endava.moderator.model.IOrder;
import com.endava.moderator.model.QuantityOrder;
import com.endava.moderator.model.RetailOrder;
import com.endava.moderator.model.TimeOrder;
import com.endava.moderator.repository.ServiceRepository;

@Service
public class OrderManager {
	private  Map<Class<? extends IOrder>, IOrderCalculator<? extends IOrder>> calculatorsMap = new HashMap<>();
	
	public OrderManager() {
		IOrderCalculator<RetailOrder> retailOrderCalculator = new RetailCalculator();
		IOrderCalculator<QuantityOrder> quantityOrderCalculator = new QuantityCalculator();
		IOrderCalculator<TimeOrder> timeOrderCalculator = new TimeCalculator();
		
		calculatorsMap.put(retailOrderCalculator.getParameterClass(), retailOrderCalculator);
		calculatorsMap.put(quantityOrderCalculator.getParameterClass(), quantityOrderCalculator);
		calculatorsMap.put(timeOrderCalculator.getParameterClass(), timeOrderCalculator);
	}

	@Autowired
	private ServiceRepository serviceRepository;
	
	public com.endava.moderator.model.Service getService(Integer id) {
		return serviceRepository.getOne(id);
	}
	
	/**
	 * Class<T> persistentClass = (Class<T>)    ((ParameterizedType)getClass().getGenericSuperclass())
	 * .getActualTypeArguments()[0];
	 * @param order
	 * @return
	 */
	public BigDecimal calculate(IOrder order) {
		@SuppressWarnings("unchecked")
		IOrderCalculator<IOrder> orderCalculator = (IOrderCalculator<IOrder>) calculatorsMap.get(order.getClass());
		BigDecimal retValuee = orderCalculator.calculate(order);
		return retValuee;
	}

}
