package com.techverito.d2h.packs.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.techverito.d2h.channels.Channel;
import com.techverito.d2h.channels.ChannelMap;
import com.techverito.d2h.channels.constants.AvailableChannel;

public class BasePack {
	
	private List<Channel> channels = new LinkedList<Channel>();
	private ChannelMap channelMapObj = new ChannelMap();
	private Map<String, Channel> channelsMap = channelMapObj.getAvailableChannelsForSubscription();
	
	public BasePack () {
		
	}
	
	public List<Channel> getAvailableSilverPackChannels () {
		
		this.channels.clear();
		this.channels.add(channelsMap.get(AvailableChannel.Zee.getChannelName()));
		this.channels.add(channelsMap.get(AvailableChannel.Sony.getChannelName()));
		this.channels.add(channelsMap.get(AvailableChannel.StarPlus.getChannelName()));
		return channels;
	}
	
	public List<Channel> getAvailableGoldPackChannels () {
		
		this.channels.clear();
		this.channels.add(channelsMap.get(AvailableChannel.Zee.getChannelName()));
		this.channels.add(channelsMap.get(AvailableChannel.Sony.getChannelName()));
		this.channels.add(channelsMap.get(AvailableChannel.StarPlus.getChannelName()));
		this.channels.add(channelsMap.get(AvailableChannel.Discovery.getChannelName()));
		this.channels.add(channelsMap.get(AvailableChannel.NatGeo.getChannelName()));
		return channels;
	}

}
