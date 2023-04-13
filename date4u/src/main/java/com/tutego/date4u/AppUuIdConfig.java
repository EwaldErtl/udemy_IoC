package com.tutego.date4u;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(proxyBeanMethods = true)
public class AppUuIdConfig {

	private final Logger logger = LoggerFactory.getLogger(getClass());


	@Bean
	public UUID appUuid() { 
		UUID uuid = UUID.randomUUID();
		logger.warn( "App UUID {} ", uuid );
		return uuid;
	}
	
	@Bean() 
	public String shortedAppUuid() { 
		String uuid = appUuid().toString().substring(0, appUuid().toString().length() / 2);
		logger.warn( "App UUID {} ", uuid );
		return uuid;
	}


}
