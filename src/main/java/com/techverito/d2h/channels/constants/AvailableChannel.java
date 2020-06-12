package com.techverito.d2h.channels.constants;

public enum AvailableChannel {

	Zee("Zee", 10),
	Sony("Sony", 15),
	StarPlus("Star Plus", 20),
	Discovery("Discovery", 10),
	NatGeo("NatGeo", 20);
	
	private String channel;
	private Integer price;
	
	private AvailableChannel (String channel, Integer price) {
		
		this.channel = channel;
		this.price = price;
	}
	
	public String getChannelName () {
		return this.channel;
	}
	
	public Integer getChannelPrice () {
		return this.price;
	}
}
