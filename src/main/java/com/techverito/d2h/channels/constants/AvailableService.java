package com.techverito.d2h.channels.constants;

public enum AvailableService {
	
	LearnEnglish("LearnEnglish Service", 200),
	LearnCooking("LearnCooking Service", 100);
	
	private String serviceName;
	private Integer servicePrice;
	
	private AvailableService (String serviceName, Integer servicePrice) {
		
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
		
	}
	
	public String getServiceName () {
		
		return this.serviceName;
	}
	
	public Integer getServicePrice () {
		
		return this.servicePrice;
	}
}
