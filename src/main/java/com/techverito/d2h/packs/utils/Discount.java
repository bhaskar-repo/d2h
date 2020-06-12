package com.techverito.d2h.packs.utils;

public class Discount {
	
	public Discount () {
		
	}
	
	public Integer returnDiscountOnPrice (final Integer price, final Integer discountPercentage) {
		
		return price / 100 * discountPercentage;
	}
}
