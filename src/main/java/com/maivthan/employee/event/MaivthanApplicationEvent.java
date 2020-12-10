package com.maivthan.employee.event;

import com.google.gson.Gson;


public class MaivthanApplicationEvent {

	private String entityName;
	
	private String entityClassName;
	
	private String eventName;
	
	private String before="";
	
	private  String after="";

	private static final long serialVersionUID = 1L;


	public String  getBefore() {
		if(before == null) {
			before="";
		}
			
		return before;
	}
	

	public void setBefore(String before) {
			this.before = before;
	}

	public void setBefore(Object before) {
				Gson gson=new Gson();
				this.before = gson.toJson(before);		
				setEntityName(before.getClass().getSimpleName());
				setEntityClassName(before.getClass().getName());
	}

	public String getAfter() {
		if(after == null) {
			after="";
		}	
		return after;
	}
	
	public <T extends Object> T getAfter(Class<T> afterClass) {
		
		if(afterClass == null) {
			return null;
		}	
		Gson gson=new Gson();
		return gson.fromJson(after, afterClass);
		
	}	
	public <T extends Object> T getBefore(Class<T> beforeClass) {
		
		if(beforeClass == null) {
			return null;
		}	
		Gson gson=new Gson();
		return gson.fromJson(before, beforeClass);
		
	}	
		

	public void setAfter(Object after) {			

			Gson gson=new Gson();
			this.after = gson.toJson(after);		
			setEntityName(after.getClass().getSimpleName());
			setEntityClassName(after.getClass().getName());
		
	}
	public void setAfter(String after) {
		this.after = after;
}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityClassName() {
		return entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}

	@Override
	public String toString() {
		return "BlumeApplicationEvent [entityName=" + entityName + ", entityClassName=" + entityClassName
				+ ", eventName=" + eventName + ", before=" + before + ", after=" + after + "]";
	}
}
