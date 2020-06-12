package com.techverito.d2h.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.techverito.d2h.channels.constants.AvailableService;

public final class ServiceMap {

	public Map<String, Service> getAvailableServicesForSubcription () {
		
		Map<String, Service> avaialableServicesMap = new HashMap<String, Service>();
		Arrays.stream(AvailableService.values()).forEach(service -> {
			avaialableServicesMap.put(service.name(), new Service(service.getServiceName(), service.getServicePrice()));
		});
		
		return avaialableServicesMap;
	}
}
