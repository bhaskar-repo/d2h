package d2h;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.channels.Channel;
import com.techverito.d2h.channels.constants.AvailableChannel;
import com.techverito.d2h.channels.constants.AvailablePack;
import com.techverito.d2h.packs.classes.Pack;
import com.techverito.d2h.packs.utils.BasePack;

@TestInstance(Lifecycle.PER_CLASS)
public class PackTest {
	
	private Pack silverPack;
	private Pack goldPack;
	
	@BeforeAll
	public void itShouldCreateAPack () {
		final BasePack basePack = new BasePack();
		this.silverPack = new Pack(AvailablePack.Silver.name(), basePack.getAvailableSilverPackChannels(), 3, 50);
		this.goldPack = new Pack(AvailablePack.Gold.name(), basePack.getAvailableGoldPackChannels(), 3, 100);
	}
	
	@Test
	public void itShouldSubscribeToThisPack () {
		Assertions.assertEquals(150, silverPack.subscribeToThisPack());
		Assertions.assertEquals(300, goldPack.subscribeToThisPack());
	}
	
	@Test
	public void itShouldAddChannelsToExistingSubscription () {
		
		List<Channel> channels = new LinkedList<Channel>();
		channels.add(new Channel(AvailableChannel.Discovery.getChannelName(), 20));
		channels.add(new Channel(AvailableChannel.Sony.getChannelName(), 30));
		
		Assertions.assertTrue(silverPack.addChannelsToExistingPackSubscription(channels));
		Assertions.assertTrue(goldPack.addChannelsToExistingPackSubscription(channels));
	}
	
	@Test 
	public void itShouldNotAddChannelsToExistingSubscription () {
		List<Channel> channels = new LinkedList<Channel>();
		Assertions.assertFalse(silverPack.addChannelsToExistingPackSubscription(channels));
		Assertions.assertFalse(goldPack.addChannelsToExistingPackSubscription(channels));
	}
	
	@Test
	public void itShouldGetNameOfThisPack () {
		
		Assertions.assertTrue("Silver".equalsIgnoreCase(this.silverPack.getNameOfThisPack()));
		Assertions.assertTrue("Gold".equalsIgnoreCase(this.goldPack.getNameOfThisPack()));
	}
	
	@Test
	public void itShouldGetPriceOfThisPack () {
		
		Assertions.assertTrue(50 == this.silverPack.getPriceOfThisPack());
		Assertions.assertTrue(100 == this.goldPack.getPriceOfThisPack());
	}
	
	@Test
	public void itShoudGetAdditionalChannelsSubscribed () {
		
		Assertions.assertFalse(this.silverPack.getAdditionalChannelsSubscibed().isEmpty());
		Assertions.assertFalse(this.goldPack.getAdditionalChannelsSubscibed().isEmpty());
		Assertions.assertEquals(2, this.silverPack.getAdditionalChannelsSubscibed().size());
		Assertions.assertEquals(2, this.goldPack.getAdditionalChannelsSubscibed().size());
	}
	
}
