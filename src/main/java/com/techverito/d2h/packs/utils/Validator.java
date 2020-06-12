package com.techverito.d2h.packs.utils;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Validator {
	
	public Predicate<String> isValidEmail = email -> 
			(null == email || "".equals(email.trim()));
			
	public Predicate<String> isValidPhoneNumber = phoneNumber -> 
			(null == phoneNumber || "".equals(phoneNumber.trim()) || phoneNumber.length() == 0);
	
	public Predicate<Integer> isMonthsGreaterThanOrEqual = months -> (months >= 3);
	
	public BiPredicate<Integer, Integer> isBalanceLessThanSubAmt = (currentBalance, subscriptionnAmt) -> (currentBalance < subscriptionnAmt);
}
