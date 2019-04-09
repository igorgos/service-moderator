package com.endava.moderator.model;

import java.math.BigDecimal;

public interface IOrder {

	Long getId();

	void setId(Long id);

	Integer getServiceId();

	void setServiceId(Integer serviceId);

	Service getService();

	void setService(Service service);

	BigDecimal getCost();

	void setCost(BigDecimal cost);

}