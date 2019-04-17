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

import com.endava.moderator.model.Client;
import com.endava.moderator.service.ClientService;

@RestController
@Scope("session")
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	@Autowired
	private ClientService clientService;
	
	private List<Client> clients;
	private Client newClient;

	public void init() {
		if (clients == null) {
			clients = clientService.findAll();
			newClient = new Client();
			newClient.setName("...");
			newClient.setDescription("...");
		}
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client getNewClient() {
		return newClient;
	}

	public void setNewClient(Client newClient) {
		this.newClient = newClient;
	}

	public void onRowEdit(RowEditEvent event) {
		Client selectedService = (Client) event.getObject();
		Client savedService = clientService.save(selectedService);
		FacesMessage msg = new FacesMessage("Client Edited", savedService.getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Client) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void addNew() {
		Client savedClient = clientService.save(newClient);
		clients.add(savedClient);
		FacesMessage msg = new FacesMessage("Client Added", savedClient.getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void doSomething() {
		logger.info("Client Controller: {}", new Date());
	}
}
