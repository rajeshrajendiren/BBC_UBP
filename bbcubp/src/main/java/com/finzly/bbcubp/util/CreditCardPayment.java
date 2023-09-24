package com.finzly.bbcubp.util;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.CreditCard;

public class CreditCardPayment {
	 private double amount;
	    private CreditCard creditCard;
	    private Set<Bill> bills;

	    // Constructors, getters, and setters...

	    @JsonCreator
	    public CreditCardPayment(
	            @JsonProperty("amount") double amount,
	            @JsonProperty("creditCard") CreditCard creditCard,
	            @JsonProperty("bills") Set<Bill> bills) {
	        this.setAmount(amount);
	        this.setCreditCard(creditCard);
	        this.setBills(bills);
	    }

		public CreditCard getCreditCard() {
			return creditCard;
		}

		public void setCreditCard(CreditCard creditCard) {
			this.creditCard = creditCard;
		}

		public Set<Bill> getBills() {
			return bills;
		}

		public void setBills(Set<Bill> bills) {
			this.bills = bills;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

}
