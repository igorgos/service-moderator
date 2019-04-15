package com.endava.moderator.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@SecondaryTable(name = "time_orders")
public class TimeOrder implements IOrder {
	private Long id;
	private Integer serviceId;
	private Work service;
	private BigDecimal cost;
	private Date startAt;
	private Date endAt;
	private Date requestedAt;
	private Date deliveredAt;
	
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

	@Column(name = "cost")
	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Column(table = "time_orders", name = "start_at")
	public Date getStartAt() {
		return startAt;
	}

	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}

	@Column(table = "time_orders", name = "end_at")
	public Date getEndAt() {
		return endAt;
	}

	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}

	@Column(table = "time_orders", name = "requested_at")
	public Date getRequestedAt() {
		return requestedAt;
	}
	
	public void setRequestedAt(Date requestedAt) {
		this.requestedAt = requestedAt;
	}
	
	@Column(table = "time_orders", name = "delivered_at")
	public Date getDeliveredAt() {
		return deliveredAt;
	}

	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
}
