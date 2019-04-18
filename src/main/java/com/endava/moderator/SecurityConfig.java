package com.endava.moderator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/javax.faces.resource/**").permitAll().anyRequest().authenticated();
		http.formLogin().loginPage("/login.jsf").permitAll().failureUrl("/login.jsf?error=true");
		http.logout().logoutSuccessUrl("/login.jsf");
		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("john.doe").password("{noop}1234").roles("USER").and()
			.withUser("jane.doe").password("{noop}5678").roles("ADMIN");
	}
}