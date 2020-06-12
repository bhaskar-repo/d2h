package com.techverito.d2h.packs.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.techverito.d2h.channels.Channel;
import com.techverito.d2h.channels.ChannelMap;
import com.techverito.d2h.channels.constants.AvailableCurrency;
import com.techverito.d2h.channels.constants.AvailablePack;
import com.techverito.d2h.packs.classes.Pack;
import com.techverito.d2h.services.ServiceMap;
import com.techverito.d2h.usersaccounts.Account;

public class DisplayInformationForOption345 {
	
	BasePack basePack = new BasePack();
	ChannelMap channelMap = new ChannelMap();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void displayAvailablePacksChannelsInfo () {
		
		ServiceMap serviceMap = new ServiceMap();
		StringJoiner joiner = new StringJoiner(",");
		System.out.println("---View available Packs, channels and services---\n");
		System.out.println("--Avaialable Packs for subcription--");
		System.out.print("Silver pack:");
		basePack.getAvailableSilverPackChannels().forEach(channel -> {
			joiner.add(channel.getNameOfThisChannel());
		});
		System.out.print(joiner.toString()+": "+ AvailablePack.Silver.getBasePrice() + " " + AvailableCurrency.Rs.name() + "\n");
		StringJoiner otherjoiner = new StringJoiner(",");
		System.out.print("Gold pack:");
		basePack.getAvailableGoldPackChannels().forEach(channel -> {
			otherjoiner.add(channel.getNameOfThisChannel());
		});
		System.out.print(otherjoiner.toString()+" : "+ AvailablePack.Gold.getBasePrice() + " " + AvailableCurrency.Rs.name() + "\n");
		System.out.println("--Available channels for subscription--");
		channelMap.getAvailableChannelsForSubscription().values().forEach(channel -> {
			System.out.println(channel.getNameOfThisChannel()+ " : "+channel.getPriceOfThisChannel() + " " + AvailableCurrency.Rs.name());
		});
		System.out.println("--Available services for subscription--");
		serviceMap.getAvailableServicesForSubcription().values().forEach(service -> {
			System.out.println(service.getNameOfThisService()+ " : "+service.getPriceOfTheService() + " " + AvailableCurrency.Rs.name());
		});
	}
	
	public void displaySubscribeToChannelPacksInfo (final Account account) throws IOException {
		
		final Validator fieldsValidator = new Validator();
		Pack pack = null;
		System.out.println("---Subscribe to channel packs---");
		System.out.println("Enter the pack you wish to subscribe");
		String packInp = reader.readLine();
		System.out.println("Enter the months");
		int months = Integer.parseInt(reader.readLine());
		if ("S".equalsIgnoreCase(packInp)) {
			pack = new Pack(AvailablePack.Silver.name(), basePack.getAvailableSilverPackChannels(), months, AvailablePack.Silver.getBasePrice());	
		}
		
		else if ("G".equalsIgnoreCase(packInp)) {
			pack = new Pack(AvailablePack.Gold.name(),basePack.getAvailableGoldPackChannels(), months, AvailablePack.Gold.getBasePrice());
		}
		
		else {
			
			System.out.println("Invalid Input");
		}
		
		if (null != pack) {
			
			Integer subscriptionAmt = pack.subscribeToThisPack();
			if (fieldsValidator.isBalanceLessThanSubAmt.test(account.getCurrentBalance(), subscriptionAmt)) {
					
				System.out.println("Do not have enough balance kindly press 2 to recharge your account");
			}
			else {
				Pack addedPack = account.addPackToUserAccount(pack);
				System.out.println("You have successfully subscribed to following pack : " + addedPack.getNameOfThisPack());
				System.out.println("Monthly price : "+ addedPack.getPriceOfThisPack() + " " + AvailableCurrency.Rs.name());
				System.out.println("No. of months : "+ months);
				Integer discountedAmt = 0;
				
				System.out.println("Subscription amount : " + subscriptionAmt + " " + AvailableCurrency.Rs.name());
				
				if (fieldsValidator.isMonthsGreaterThanOrEqual.test(months)) {
					Discount discount = new Discount();
					discountedAmt = discount.returnDiscountOnPrice(subscriptionAmt, 10);
				}
				
				subscriptionAmt -= discountedAmt;
				System.out.println("Discount applied : " + discountedAmt + " " + AvailableCurrency.Rs.name());
				System.out.println("Final price after discount : " + subscriptionAmt + " " + AvailableCurrency.Rs.name());
				System.out.println("Account balance : " + account.updateAccountBalance(subscriptionAmt) + " " + AvailableCurrency.Rs.name());
				System.out.println("Email notification sent successfully");
				System.out.println("SMS notification sent successfully");
			}
		}
		
	}
	
	public void displayAddChannelsToExistingSubInfo (final Account account) throws IOException {
		
		final Validator fieldsValidator = new Validator();
		System.out.println("---Add channels to existing subscription---");
		System.out.println("Enter channel names to add (seperated by commas)");
		String channelsString  = reader.readLine();
		String[] channelValues = channelsString.split(",");
		List<Channel> channels = new LinkedList<Channel>();
		Map<String, Channel> channelMapValues = channelMap.getAvailableChannelsForSubscription();
		Arrays.stream(channelValues).forEach(channelValue -> {
			if (channelMapValues.containsKey(channelValue.trim())) {
				channels.add(channelMapValues.get(channelValue.trim()));
			}
			
		});
		
		if (!channels.isEmpty()) {
			Pack subscribedPack = account.getSubscibedPack();
			if (null != subscribedPack) subscribedPack.addChannelsToExistingPackSubscription(channels);
			Integer channelsPrice = channels.stream().mapToInt(channel -> channel.getPriceOfThisChannel()).sum();
			if (fieldsValidator.isBalanceLessThanSubAmt.test(account.getCurrentBalance(), channelsPrice)) {
				System.out.println("Do not have enough balance kindly press 2 to recharge your account");
			}
			else {
				System.out.println("Channels added successfully");
				System.out.println("Account balance : " + account.updateAccountBalance(channelsPrice) + " " + AvailableCurrency.Rs.name());
			}
		}
		else {
			System.out.println("Invalid channel/s");
		}
		
	}
}
