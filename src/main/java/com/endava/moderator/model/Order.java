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
public class Order implements IOrder {
	private Long id;
	private Integer serviceId;
	private Work service;
	private BigDecimal cost;
	
	/* (non-Javadoc)
	 * @see com.endava.moderator.model.IOrder#getId()
	 */
	@Override
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.endava.moderator.model.IOrder#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.endava.moderator.model.IOrder#getServiceId()
	 */
	@Override
	@Column(name = "service_id")
	public Integer getServiceId() {
		return serviceId;
	}
	
	/* (non-Javadoc)
	 * @see com.endava.moderator.model.IOrder#setServiceId(java.lang.Integer)
	 */
	@Override
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	
    /* (non-Javadoc)
	 * @see com.endava.moderator.model.IOrder#getService()
	 */
    @Override
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "id", insertable = false, updatable = false, foreignKey=@ForeignKey(name = "FK_order_services"))
	public Work getService() {
		return service;
	}

	/* (non-Javadoc)
	 * @see com.endava.moderator.model.IOrder#setService(com.endava.moderator.model.Service)
	 */
	@Override
	public void setService(Work service) {
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see com.endava.moderator.model.IOrder#getCost()
	 */
	@Override
	@Column(name = "cost")
	public BigDecimal getCost() {
		return cost;
	}
	
	/* (non-Javadoc)
	 * @see com.endava.moderator.model.IOrder#setCost(java.math.BigDecimal)
	 */
	@Override
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
}
