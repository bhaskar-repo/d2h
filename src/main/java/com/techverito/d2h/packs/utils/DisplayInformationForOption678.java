package com.techverito.d2h.packs.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

import com.techverito.d2h.channels.constants.AvailableCurrency;
import com.techverito.d2h.packs.classes.Pack;
import com.techverito.d2h.services.Service;
import com.techverito.d2h.services.ServiceMap;
import com.techverito.d2h.users.User;
import com.techverito.d2h.usersaccounts.Account;

public class DisplayInformationForOption678 {
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void displaySubscribeToSpeacialServicesInfo (final Account account) throws IOException {
		
		ServiceMap serviceMap = new ServiceMap();
		System.out.println("---Subscribe to speacial services---");
		System.out.println("Enter the service name");
		String serviceName = reader.readLine();
		Service service = serviceMap.getAvailableServicesForSubcription().get(serviceName.trim());
		if (null == service) {
			System.out.println("Invalid service/s");
		}
		else {
			Integer serviceAmt = service.getPriceOfTheService();
			account.addServiceToUserAccount(service);
			System.out.println("Service subscribed successfully");
			System.out.println("Account balance : " + account.updateAccountBalance(serviceAmt) + " " + AvailableCurrency.Rs.name());
			System.out.println("Email notification sent successfully");
			System.out.println("SMS notification sent successfully");
		}
	}
	
	public void displaySubscriptionDetails (final Account account) {
		
		StringJoiner subDetailsJoiner = new StringJoiner(" + ");
		System.out.println("---View current subscription details---");
		
		Pack subscribedPack = account.getSubscibedPack();
		if (null != subscribedPack) {
			subDetailsJoiner.add(subscribedPack.getNameOfThisPack());
			subscribedPack.getAdditionalChannelsSubscibed().forEach(channel -> {
				subDetailsJoiner.add(channel.getNameOfThisChannel());
			});
		}
		System.out.println("Currently subscribed packs and channels : " + subDetailsJoiner.toString());
		StringJoiner subDetailsJoinerServices = new StringJoiner(" + ");
		account.getCurrentlySubscibedServices().forEach(currentService -> {
			subDetailsJoinerServices.add(currentService.getNameOfThisService());
		});
		System.out.println("Currently subscribed services : " + subDetailsJoinerServices.toString());
	}
	
	public void displayUpdateEmailAndPhoneInfo (final Account account) throws IOException {
		
		System.out.println("Update email and phone number for notifications");
		System.out.println("Enter the email");
		String email = reader.readLine();
		System.out.println("Enter the phone");
		String phone = reader.readLine();
		User user = account.getUserAssociatedWithThisAccount();
		user.updateEmailOfThisUser(email);
		user.updatePhoneNumberOfThisUser(phone);
		System.out.println("Email and phone updated successfully");
	}
}
