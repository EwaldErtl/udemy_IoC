package com.tutego.date4u;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.tutego.date4u.event.NewPhotoEvent;

@Service
public class Statistic {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Async
	@EventListener
	void onNewPhotoEvent(NewPhotoEvent event) { 
		logger.info("onNewPhotoEvent {}", event);
	}
}
