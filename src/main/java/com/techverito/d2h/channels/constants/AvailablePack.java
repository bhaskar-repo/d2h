package com.techverito.d2h.channels.constants;

public enum AvailablePack {
	
	Silver(50),
	Gold(100);
	
	private Integer basePrice;
	
	private AvailablePack (Integer basePrice) {
		
		this.basePrice = basePrice;
	}
	
	public Integer getBasePrice () {
		
		return this.basePrice;
	}
}
