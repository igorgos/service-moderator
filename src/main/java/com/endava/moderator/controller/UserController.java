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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.endava.moderator.model.User;
import com.endava.moderator.security.SecurityService;
import com.endava.moderator.security.UserValidator;
import com.endava.moderator.service.UserService;

@Controller
@Scope("session")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
    @Autowired
    private SecurityService securityService;

	@Autowired
    private UserValidator userValidator;

	private List<User> users;
	private User newUser;

    @GetMapping("/pp")
    public String pp(Model model) {
        model.addAttribute("userForm", new User());

        return "pp";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

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
