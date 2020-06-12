package com.techverito.d2h.channels;

public class Channel {
	
	private String name;
	private Integer price;
	
	public Channel(String name, Integer price) {
		this.name = name;
		this.price = price;
	}
	
	public Integer getPriceOfThisChannel () {
		return this.price;
	}
	
	public String getNameOfThisChannel () {
		return this.name;
	}
}
