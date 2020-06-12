package com.techverito.d2h.channels;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.techverito.d2h.channels.constants.AvailableChannel;

public final class ChannelMap {
	
	public ChannelMap () {
		
	}

	public Map<String, Channel> getAvailableChannelsForSubscription() {
		
		Map<String, Channel> availableChannelsMap = new LinkedHashMap<String, Channel>();
		
		Arrays.stream(AvailableChannel.values()).forEach(channel -> {
			String channelName = channel.getChannelName();
			availableChannelsMap.put(channelName, new Channel(channelName, channel.getChannelPrice()));
		});
		
		return availableChannelsMap;
	}
}
