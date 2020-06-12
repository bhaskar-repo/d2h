package com.techverito.d2h.users;

import com.techverito.d2h.packs.utils.Validator;

public class User {

	private String name;
	private String email;
	private String phoneNumber;
	private Validator fieldsValidator = new Validator();
	
	public User(String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String updateEmailOfThisUser (String newEmail) {
		
		if (fieldsValidator.isValidEmail.test(newEmail)) {
			return "Invalid Email";
		}
		return this.email = newEmail;
	}
	
	public String updatePhoneNumberOfThisUser (String newPhoneNumber) {
		
		if (fieldsValidator.isValidPhoneNumber.test(newPhoneNumber)) {
			return "Invalid Phone Number";
		}
		return this.phoneNumber = newPhoneNumber;
	}
}
