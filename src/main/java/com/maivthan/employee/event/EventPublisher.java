package com.maivthan.employee.event;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.data.rest.core.event.AfterSaveEvent;
import org.springframework.stereotype.Component;
@Component
public class EventPublisher implements ApplicationEventPublisherAware{
	
	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		
		this.publisher = applicationEventPublisher;		
	}
	//@Async
	public void publishEvent(MaivthanApplicationEvent maivthanApplicationEvent) {
		
		publisher.publishEvent(new AfterSaveEvent(maivthanApplicationEvent));
	}
}
