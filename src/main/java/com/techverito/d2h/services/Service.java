package com.techverito.d2h.services;

public class Service {
	
	private String name;
	private Integer price;
	
	public Service(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getNameOfThisService () {
		return this.name;
	}
	
	public Integer getPriceOfTheService () {
		return this.price;
	}
}
