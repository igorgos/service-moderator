package com.endava.moderator.model;

import java.math.BigDecimal;

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