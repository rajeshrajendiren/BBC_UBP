package com.finzly.bbcubp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CreditCard {
	@Id
	private String creditCardNumber;
	private String cardHolderName;
	private String expiryDate;
	private int cvv;
	private double cashLimit;
	
	public CreditCard(String creditCardNumber, String cardHolderName, String expiryDate, int cvv) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	public CreditCard() {
		super();
	}

	public CreditCard(String creditCardNumber, String cardHolderName, String expiryDate, int cvv, double cashLimit) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.cashLimit = cashLimit;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public double getCashLimit() {
		return cashLimit;
	}

	public void setCashLimit(double cashLimit) {
		this.cashLimit = cashLimit;
	}
	
	
	

}
