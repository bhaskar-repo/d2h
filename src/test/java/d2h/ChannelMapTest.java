package d2h;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.channels.Channel;
import com.techverito.d2h.channels.ChannelMap;

@TestInstance(Lifecycle.PER_CLASS)
public class ChannelMapTest {
	
	private ChannelMap channelMap;
	
	@BeforeAll
	public void itShouldCreateChannelMap () {
		
		this.channelMap = new ChannelMap();
	}
	
	@Test
	public void itShouldCheckAvailableChannelsForSubcription () {
		
		Map<String, Channel> availableChannels = this.channelMap.getAvailableChannelsForSubscription();
		Assertions.assertFalse(availableChannels.isEmpty());
		Assertions.assertEquals(5, availableChannels.size());
	}
}
