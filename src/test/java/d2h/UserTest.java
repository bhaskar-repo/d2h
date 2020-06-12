package d2h;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.users.User;

@TestInstance(Lifecycle.PER_CLASS)
public class UserTest {

	private User user;
	
	@BeforeAll
	public void itShouldCreateAUser() {
		this.user = new User("bhaskar", "b@gmail.com", "1212121212");
	}
	
	@Test
	public void itShouldUpdateEmailOfTheUser () {
		
		Assertions.assertEquals("abc@gmail.com", this.user.updateEmailOfThisUser("abc@gmail.com"));
	}
	
	@Test
	public void itShouldNotUpdateEmailOfTheUser () {
		
		Assertions.assertEquals("Invalid Email", this.user.updateEmailOfThisUser(""));
		Assertions.assertEquals("Invalid Email", this.user.updateEmailOfThisUser(null));
	}
	
	@Test
	public void itShouldUpdatePhoneNumberOfTheUser () {
		
		Assertions.assertEquals("1234567890", this.user.updatePhoneNumberOfThisUser("1234567890"));
	}
	
	@Test
	public void itShouldNotUpdatePhoneNUmberOfTheUser () {
		
		Assertions.assertEquals("Invalid Phone Number", this.user.updatePhoneNumberOfThisUser(""));
		Assertions.assertEquals("Invalid Phone Number", this.user.updatePhoneNumberOfThisUser(null));
	}
}
