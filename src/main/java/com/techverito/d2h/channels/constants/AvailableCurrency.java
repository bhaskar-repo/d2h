package com.techverito.d2h.channels.constants;

public enum AvailableCurrency {

	Rs(1);
	
	private Integer currencyValue;
	
	private AvailableCurrency (Integer currencyValue) {
		this.currencyValue = currencyValue;
	}
	
	public Integer getCurrencyValue () {
		return this.currencyValue;
	}
}
