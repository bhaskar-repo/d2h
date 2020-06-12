package d2h;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.techverito.d2h.services.Service;
import com.techverito.d2h.services.ServiceMap;

@TestInstance(Lifecycle.PER_CLASS)
public class ServiceMapTest {

	private ServiceMap serviceMap;
	
	@BeforeAll
	public void itShouldCreateServiceMap () {
		this.serviceMap = new ServiceMap();
	}
	
	@Test
	public void itShouldGetAvailableServicesForSubcription () {
		
		Map<String, Service> availableServices = this.serviceMap.getAvailableServicesForSubcription();
		Assertions.assertFalse(availableServices.isEmpty());
		Assertions.assertEquals(2, availableServices.size());
	}
}
