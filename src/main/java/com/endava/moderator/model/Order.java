package com.endava.moderator.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	private Long id;
	private Integer serviceId;
	private Service service;
	private BigDecimal cost;
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "id", insertable = false, updatable = false, foreignKey=@ForeignKey(name = "FK_order_services"))
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Column(name = "cost")
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
}
