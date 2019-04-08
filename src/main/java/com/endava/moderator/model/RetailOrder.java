package com.endava.moderator.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@SecondaryTable(name = "retail_order")
public class RetailOrder {
	private Long id;
	private Integer serviceId;
	private BigDecimal cost;
	private Integer amount;
	private Date requestedAt;
	private Date deliveredAt;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "service_id")
	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "cost")
	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Column(table = "retail_order", name = "amount")
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	@Column(table = "retail_order", name = "requested_at")
	public Date getRequestedAt() {
		return requestedAt;
	}
	
	public void setRequestedAt(Date requestedAt) {
		this.requestedAt = requestedAt;
	}
	
	@Column(table = "retail_order", name = "delivered_at")
	public Date getDeliveredAt() {
		return deliveredAt;
	}

	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
}
