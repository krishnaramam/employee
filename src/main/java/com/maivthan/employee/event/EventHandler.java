package com.maivthan.employee.event;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Component
@RepositoryEventHandler
public class EventHandler {
	
	@Value("${maivthan.eventpublisher}")
	private String eventPublisher;	
	
    
    @HandleAfterSave
    @Async
    public void handleAfterSave(MaivthanApplicationEvent maivthanApplicationEvent){
   
		RestTemplate restTemplate = new RestTemplate();
		Gson gson=new Gson();
		try {
		System.out.print("EventHandler:"+maivthanApplicationEvent+":"+eventPublisher);
		restTemplate.postForObject(eventPublisher,maivthanApplicationEvent,MaivthanApplicationEvent.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
    
	public String getEventPublisher() {
		return eventPublisher;
	}
	public void setEventPublisher(String eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
	
}
