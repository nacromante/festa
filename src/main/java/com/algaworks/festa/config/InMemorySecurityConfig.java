package com.algaworks.festa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder biulder) throws Exception{
		biulder.inMemoryAuthentication().withUser("fred").password("1234").roles("USER")
		.and()
		.withUser("Pedro").password("123").roles("USER")
		.and()
		.withUser("Maria").password("12").roles("USER");
	}

}
