package com.endava.moderator;

import java.util.HashMap;

import javax.faces.webapp.FacesServlet;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.endava.moderator.utils.ViewScope;
import com.sun.faces.config.ConfigureListener;

@SpringBootApplication
@ComponentScan({"com.endava.moderator", "com.endava.moderator.model", "com.endava.moderator.repository", "com.endava.moderator.business"})
public class ServiceModeratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceModeratorApplication.class, args);
    }
    
	@Bean
	public static ViewScope viewScope() {
		return new ViewScope();
	}

	/**
	 * Allows the use of @Scope("view") on Spring @Component, @Service and @Controller
	 * beans
	 */
	@Bean
	public static CustomScopeConfigurer scopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("view", viewScope());
		configurer.setScopes(hashMap);
		return configurer;
	}

	/*
	 * Below sets up the Faces Servlet for Spring Boot
	 */
	@Bean
	public FacesServlet facesServlet() {
		return new FacesServlet();
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<>(facesServlet(), "*.jsf");
		registration.setName("FacesServlet");
		return registration;
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}
    
}
