package d2h;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.services.Service;

@TestInstance(Lifecycle.PER_CLASS)
public class ServiceTest {

	private Service service;
	
	@BeforeAll
	public void itShouldCreateService () {
		
		this.service = new Service("LearnEnglish", 200);
	}
	
	@Test
	public void itShouldGetNameOfThisService () {
		
		Assertions.assertEquals("LearnEnglish", this.service.getNameOfThisService());
	}
	
	@Test
	public void itShouldGetPriceOfThisService () {
		
		Assertions.assertEquals(200, this.service.getPriceOfTheService());
	}
}
