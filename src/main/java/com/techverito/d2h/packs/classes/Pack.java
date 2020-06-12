package com.techverito.d2h.packs.classes;

import java.util.LinkedList;
import java.util.List;

import com.techverito.d2h.channels.Channel;

public class Pack {
	
	private String name;
	private List<Channel> channels;
	private List<Channel> additionalChannels = new LinkedList<Channel>();
	private Integer months;
	private Integer price;
	
	public Pack (String name, List<Channel> channels, Integer months, Integer price) {
		
		this.name = name;
		this.channels = channels;
		this.months = months;
		this.price = price;
	}
	
	public Integer subscribeToThisPack() {
		
		return this.months * this.price;
	}

	public boolean addChannelsToExistingPackSubscription(List<Channel> channels) {
		
		if (channels.isEmpty()) {
			return Boolean.FALSE;
		}
		
		this.additionalChannels.addAll(channels);
		return this.channels.addAll(channels);
		
	}
	
	public String getNameOfThisPack() {
		return this.name;
	}
	
	public Integer getPriceOfThisPack() {
		return this.price;
	}
	
	public List<Channel> getAdditionalChannelsSubscibed () {
		return this.additionalChannels;
	}
}
