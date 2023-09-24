package com.finzly.bbcubp.util;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.CreditCard;
import com.finzly.bbcubp.model.DebitCard;

public class DebitCardPayment {
	 private double amount;
	    private DebitCard debitCard;
	    private Set<Bill> bills;

	    // Constructors, getters, and setters...

	    @JsonCreator
	    public DebitCardPayment(
	            @JsonProperty("amount") double amount,
	            @JsonProperty("debitCard") DebitCard debitCard,
	            @JsonProperty("bills") Set<Bill> bills) {
	        this.setAmount(amount);
	        this.setDebitCard(debitCard);
	        this.setBills(bills);
	    }

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public DebitCard getDebitCard() {
			return debitCard;
		}

		public void setDebitCard(DebitCard debitCard) {
			this.debitCard = debitCard;
		}

		public Set<Bill> getBills() {
			return bills;
		}

		public void setBills(Set<Bill> bills) {
			this.bills = bills;
		}

		
		}

