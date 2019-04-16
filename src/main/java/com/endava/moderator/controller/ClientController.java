package com.endava.moderator.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PhaseId;

import org.primefaces.behavior.ajax.AjaxBehavior;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;
import org.primefaces.util.ComponentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import com.endava.moderator.model.Client;
import com.endava.moderator.service.ClientService;

@RestController
@Scope("view")
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	@Autowired
	private ClientService clientService;
	private List<Client> clients;

	public void init() {
		if (clients == null) {
			clients = clientService.findAll();
		}
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public void onRowEdit(RowEditEvent event) {
		Client selectedService = (Client) event.getObject();
		Client savedService = clientService.save(selectedService);
		FacesMessage msg = new FacesMessage("Service Edited", savedService.getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Client) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onAddNew() {
		Client newService = new Client();
		clients.add(newService);
		FacesMessage msg = new FacesMessage("New Service added", newService.getName());
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		currentInstance.addMessage(null, msg);

		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {

			DataTable table = (DataTable) facesContext.getViewRoot().findComponent("form:services");

			UIComponent uiTable = ComponentUtils.findParentForm(facesContext, table);

			final AjaxBehavior behavior = new AjaxBehavior();
			RowEditEvent rowEditEvent = new RowEditEvent(uiTable, behavior, table.getRowData());

			rowEditEvent.setPhaseId(PhaseId.UPDATE_MODEL_VALUES);
			table.broadcast(rowEditEvent);

		} catch (AbortProcessingException e) {
			e.printStackTrace();
		}

//        RequestContext requestContext = RequestContext.getCurrentInstance(currentInstance);
//        requestContext.execute("$('.styleEventosPlanPrestacion tbody.ui-datatable-data tr:first-child td div.ui-row-editor a.ui-row-editor-pencil').click()");
	}

	public void doSomething() {
		logger.info("Client Controller: {}", new Date());
	}
}
