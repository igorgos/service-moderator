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

import com.endava.moderator.model.Work;
import com.endava.moderator.service.WorkService;

@RestController
@Scope("view")
public class WorkController {
	private static final Logger logger = LoggerFactory.getLogger(WorkController.class);
	@Autowired
	private WorkService workService;
	private List<Work> works;

	public void init() {
		if (works == null) {
			works = workService.findAll();
		}
	}

	public List<Work> getWorks() {
		return works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

	public void onRowEdit(RowEditEvent event) {
		Work selectedService = (Work) event.getObject();
		Work savedService = workService.save(selectedService);
		FacesMessage msg = new FacesMessage("Service Edited", savedService.getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Work) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onAddNew() {
		Work newService = new Work();
		works.add(newService);
		FacesMessage msg = new FacesMessage("New Service added", newService.getName());
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		currentInstance.addMessage(null, msg);
	}

	public void doSomething() {
		logger.info("Work Controller: {}", new Date());
	}
}
