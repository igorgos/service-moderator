package com.endava.moderator.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import com.endava.moderator.model.User;
import com.endava.moderator.service.UserService;

@RestController
@Scope("session")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	private List<User> users;
	private User newUser;

	public void init() {
		if (users == null) {
			users = userService.findAll();
			newUser = new User();
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public void setClients(List<User> users) {
		this.users = users;
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newClient) {
		this.newUser = newClient;
	}

	public void onRowEdit(RowEditEvent event) {
		User selectedService = (User) event.getObject();
		User savedService = userService.save(selectedService);
		FacesMessage msg = new FacesMessage("Client Edited", savedService.getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((User) event.getObject()).getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void addNew() {
		User savedUser = userService.save(newUser);
		users.add(savedUser);
		FacesMessage msg = new FacesMessage("Client Added", savedUser.getUsername());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void doSomething() {
		logger.info("Client Controller: {}", new Date());
	}
}
