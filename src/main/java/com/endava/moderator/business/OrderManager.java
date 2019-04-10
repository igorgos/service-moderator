package com.endava.moderator.business;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endava.moderator.business.order.IOrderCalculator;
import com.endava.moderator.model.IOrder;
import com.endava.moderator.repository.ServiceRepository;
import com.endava.moderator.utils.OrderCollectionFactory;
import com.endava.moderator.utils.ServiceException;

@Service
public class OrderManager {
	private  Map<String, IOrderCalculator<IOrder>> calculatorsMap = new HashMap<>();
	
	public OrderManager() {
		try {
			calculatorsMap = OrderCollectionFactory.getChargeInstructionMap();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
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
		IOrderCalculator<IOrder> orderCalculator = (IOrderCalculator<IOrder>) calculatorsMap.get(order.getClass().getName());
		BigDecimal retValuee = orderCalculator.calculate(order);
		return retValuee;
	}

}
