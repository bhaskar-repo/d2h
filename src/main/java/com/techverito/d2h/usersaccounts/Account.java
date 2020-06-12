package com.techverito.d2h.usersaccounts;

import java.util.LinkedList;
import java.util.List;

import com.techverito.d2h.packs.classes.Pack;
import com.techverito.d2h.services.Service;
import com.techverito.d2h.users.User;

public class Account {

	private Integer balance;
	private User user;
	private Pack pack;
	private List<Service> services = new LinkedList<Service>();
	
	public Account (User user, Integer balance) {
		
		this.balance = balance;
		this.user = user;
	}
	
	public Pack addPackToUserAccount (Pack pack) {
		return this.pack = pack;
	}
	
	public boolean addServiceToUserAccount (Service service) {
		return this.services.add(service);
	}
	
	public List<Service> getCurrentlySubscibedServices () {
		return this.services;
	}
	
	public Integer getCurrentBalance () {
		
		return this.balance;
	}
	
	public Integer rehargeThisAccount (Integer rechargeAmount) {
		
		return this.balance += rechargeAmount;
	}
	
	public Integer updateAccountBalance (Integer balance) {
		
		return this.balance -= balance;
	}
	
	public Pack getSubscibedPack () {
		return this.pack;
	}
	
	public User getUserAssociatedWithThisAccount () {
		return this.user;
	}
}
