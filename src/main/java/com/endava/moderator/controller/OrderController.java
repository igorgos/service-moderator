package com.endava.moderator.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.endava.moderator.model.order.Order;
import com.endava.moderator.service.OrderService;

@Controller
@Scope("session")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;
	
	private List<Order> orders;
	private Order newOrder;

	public void init() {
		if (orders == null) {
			orders = orderService.findAll();
			newOrder = new Order();
		}
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(Order newOrder) {
		this.newOrder = newOrder;
	}

	public void addNew() {
		Order savedOrder = orderService.save(newOrder);
		orders.add(savedOrder);
		FacesMessage msg = new FacesMessage("Order Added", savedOrder.getId().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void doSomething() {
		logger.info("Order Controller: {}", new Date());
	}
}
