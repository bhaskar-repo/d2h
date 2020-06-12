package d2h;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.channels.constants.AvailablePack;
import com.techverito.d2h.packs.classes.Pack;
import com.techverito.d2h.packs.utils.BasePack;
import com.techverito.d2h.services.Service;
import com.techverito.d2h.users.User;
import com.techverito.d2h.usersaccounts.Account;

@TestInstance(Lifecycle.PER_CLASS)
public class AccountTest {
	
	private Account account;
	
	@BeforeAll
	public void itShouldCreateAnAccount() {
		
		this.account = new Account(new User("bhaskar", "b@gmail.com", "1212121212"), 100);
	}
	
	@Test
	public void itShouldAddPackToUserAccount () {
		
		final BasePack basePack = new BasePack();
		Pack pack = new Pack(AvailablePack.Silver.name(), basePack.getAvailableSilverPackChannels(), 3, 50);
		Pack addedPack = this.account.addPackToUserAccount(pack);
		Assertions.assertNotNull(addedPack);
		Assertions.assertEquals("Silver", addedPack.getNameOfThisPack());
	}

	@Test
	public void itShouldAddServiceToUserAccount () {
		
		Service service = new Service("LearnEnglish", 200);
		Assertions.assertTrue(this.account.addServiceToUserAccount(service));
		Assertions.assertFalse(this.account.getCurrentlySubscibedServices().isEmpty());
	}
	
	@Test
	public void itShouldGetCurrentlySubscibedServices () {
		
		Service service = new Service("NewService", 100);
		Assertions.assertTrue(this.account.addServiceToUserAccount(service));
		Assertions.assertFalse(this.account.getCurrentlySubscibedServices().isEmpty());
		Assertions.assertEquals(1, this.account.getCurrentlySubscibedServices().size());
	}
	
	@Test
	public void itShouldRechargeThisAccount () {
		
		Assertions.assertEquals(600, this.account.rehargeThisAccount(500));
	}
	
	@Test
	public void itShouldUpdateAccountBalance () {
		
		Assertions.assertEquals(550, this.account.updateAccountBalance(50));
	}
	
	@Test
	public void itShouldGetCurrentBalance () {
		
		Assertions.assertEquals(550, this.account.getCurrentBalance());
	}
	
	@Test
	public void itShouldGetSubscribedPack () {
		
		final BasePack basePack = new BasePack();
		Pack pack = new Pack(AvailablePack.Silver.name(), basePack.getAvailableSilverPackChannels(), 3, 50);
		this.account.addPackToUserAccount(pack);
		Pack subScribedPack = this.account.getSubscibedPack();
		Assertions.assertNotNull(subScribedPack);
	}
	
	@Test
	public void itShouldGetUserAssociatedWithThisAccount () {
		
		Assertions.assertNotNull(this.account.getUserAssociatedWithThisAccount());
	}

}
