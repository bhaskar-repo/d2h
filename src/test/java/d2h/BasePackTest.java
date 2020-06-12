package d2h;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.packs.utils.BasePack;

@TestInstance(Lifecycle.PER_CLASS)
public class BasePackTest {

	private BasePack basePack;
	
	@BeforeAll
	public void itShouldCreateABasePack () {
		
		this.basePack = new BasePack();
	} 
	
	@Test
	public void itShouldGetAvailableSilverPackChannels () {
		
		Assertions.assertFalse(this.basePack.getAvailableSilverPackChannels().isEmpty());
		Assertions.assertEquals(3, this.basePack.getAvailableSilverPackChannels().size());
		
	}
	
	@Test
	public void itShouldGetAvailableGoldPackChannels () {
		
		Assertions.assertFalse(this.basePack.getAvailableGoldPackChannels().isEmpty());
		Assertions.assertEquals(5, this.basePack.getAvailableGoldPackChannels().size());
		
	}
}
