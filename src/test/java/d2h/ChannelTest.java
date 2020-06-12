package d2h;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.channels.Channel;

@TestInstance(Lifecycle.PER_CLASS)
public class ChannelTest {
	
	private Channel channel;
	
	@BeforeAll
	public void itShouldCreateAChannel () {
		
		this.channel = new Channel("ABC", 10);
	}
	
	@Test
	public void itShouldGetExpectedNameOfThisChannel () {
		Assertions.assertEquals("ABC", this.channel.getNameOfThisChannel());
	}
	
	@Test
	public void itShouldGetUnExpectedNameOfThisChannel () {
		Assertions.assertNotEquals("ABF", this.channel.getNameOfThisChannel());
	}
	
	@Test
	public void itShouldGetExpectedPriceOfThisChannel () {
		Assertions.assertEquals(10, this.channel.getPriceOfThisChannel());
	}
	
	@Test
	public void itShouldGetUnExpectedPriceOfThisChannel () {
		Assertions.assertNotEquals(5, this.channel.getPriceOfThisChannel());
	}
	
}
