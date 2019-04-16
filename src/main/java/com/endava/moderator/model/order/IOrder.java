package com.endava.moderator.model.order;

import java.math.BigDecimal;

import com.endava.moderator.model.Work;

public interface IOrder {

	Long getId();

	void setId(Long id);

	Integer getServiceId();

	void setServiceId(Integer serviceId);

	Work getService();

	void setService(Work service);

	BigDecimal getCost();

	void setCost(BigDecimal cost);

}