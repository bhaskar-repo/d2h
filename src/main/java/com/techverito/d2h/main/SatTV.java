package com.techverito.d2h.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.techverito.d2h.channels.constants.AvailableCurrency;
import com.techverito.d2h.packs.utils.DisplayInformationForOption345;
import com.techverito.d2h.packs.utils.DisplayInformationForOption678;
import com.techverito.d2h.users.User;
import com.techverito.d2h.usersaccounts.Account;

public class SatTV {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		DisplayInformationForOption345 disInformationForOption345 = new DisplayInformationForOption345();
		DisplayInformationForOption678 displayInformationForOption678 = new DisplayInformationForOption678();
		Account account = new Account(new User("Bhaskar", "abc@gmail.com", "232323233"),  100);
		
		System.out.println("Welcome to SatTV");
		showMenu();
				
		do {
			
			System.out.println("Enter your choice");
			choice = Integer.parseInt(reader.readLine());
			
			switch (choice) {
				
				case 1 :
					System.out.println("Current balacne is : " + account.getCurrentBalance() + " " +AvailableCurrency.Rs.name());
					showMenu();
					break;
				case 2: 
					System.out.println("Enter amount to recharge");
					account.rehargeThisAccount(Integer.parseInt(reader.readLine()));
					System.out.println("Recharge completed successFully. Current balance is : " + account.getCurrentBalance() + " " +AvailableCurrency.Rs.name());
					showMenu();
					break;
				case 3:
					disInformationForOption345.displayAvailablePacksChannelsInfo();
					showMenu();
					break;
				case 4:
					disInformationForOption345.displaySubscribeToChannelPacksInfo(account);
					showMenu();
					break;
				case 5:
					disInformationForOption345.displayAddChannelsToExistingSubInfo(account);
					showMenu();
					break;
				case 6:
					displayInformationForOption678.displaySubscribeToSpeacialServicesInfo(account);
					showMenu();
					break;
				case 7:
					displayInformationForOption678.displaySubscriptionDetails(account);
					showMenu();
					break;
				case 8:
					displayInformationForOption678.displayUpdateEmailAndPhoneInfo(account);
					showMenu();
					break;
				case 9:
					System.out.println("Exited");
					break;
				default:
					showMenu();
					break;
					
			}
			
		}while (choice != 9);
		
		reader.close();
	}
	
	private static void showMenu () {
		
		System.out.println("\n1. View current balance in the account\n"
				+ "2. Recharge account\n"
				+ "3. View available Packs, channels and services\n"
				+ "4. Subscribe to base packs\n"
				+ "5. Add channels to an existing subscription\n"
				+ "6. Subscribe to special services\n"
				+ "7. View current subcription details\n"
				+ "8. Update email and phone number for notifications\n"
				+ "9. Exit");
	}
}
