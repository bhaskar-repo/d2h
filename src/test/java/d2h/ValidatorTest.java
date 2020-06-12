package d2h;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.packs.utils.Validator;

@TestInstance(Lifecycle.PER_CLASS)
public class ValidatorTest {
	
	private Validator validator;
	
	@BeforeAll
	public void itShouldCreateValidator () {
		
		this.validator = new Validator();
	}
	
	@Test
	public void itShouldCheckIsValidEmail () {
		
		Assertions.assertFalse(this.validator.isValidEmail.test("abc@gmail.com"));
	}
	
	@Test
	public void itShouldCheckIsInValidEmail () {
		
		Assertions.assertTrue(this.validator.isValidEmail.test(""));
		Assertions.assertTrue(this.validator.isValidEmail.test(null));
	}
	
	@Test
	public void itShouldCheckIsValidPhoneNumber () {
		
		Assertions.assertFalse(this.validator.isValidPhoneNumber.test("345345356"));
	}
	
	@Test
	public void itShouldCheckIsInValidPhoneNumber () {
		
		Assertions.assertTrue(this.validator.isValidPhoneNumber.test(""));
		Assertions.assertTrue(this.validator.isValidPhoneNumber.test(null));
	}
	
	@Test
	public void itShouldCheckIsMonthsGreaterThanOrEqual () {
		
		Assertions.assertTrue(this.validator.isMonthsGreaterThanOrEqual.test(5));
	}
	
	@Test
	public void itShouldCheckIsMonthsNotGreaterThanOrEqual () {
		
		Assertions.assertFalse(this.validator.isMonthsGreaterThanOrEqual.test(2));
	}
	
	@Test
	public void itShouldCheckIsBalanceLessThanSubAmt () {
		
		Assertions.assertTrue(this.validator.isBalanceLessThanSubAmt.test(300, 500));
	}
	
	@Test
	public void itShouldCheckIsBalanceNotLessThanSubAmt () {
		
		Assertions.assertFalse(this.validator.isBalanceLessThanSubAmt.test(500, 300));
	}
}
