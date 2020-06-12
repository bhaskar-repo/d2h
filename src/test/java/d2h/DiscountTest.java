package d2h;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.packs.utils.Discount;

@TestInstance(Lifecycle.PER_CLASS)
public class DiscountTest {
	
	private Discount discount;
	
	@BeforeAll
	public void itShouldCreateDiscount () {
		this.discount = new Discount();
	}
	
	@Test
	public void itShouldReturnDiscountOnPrice () {
		
		Assertions.assertEquals(30, this.discount.returnDiscountOnPrice(300, 10));
	}
	
}
