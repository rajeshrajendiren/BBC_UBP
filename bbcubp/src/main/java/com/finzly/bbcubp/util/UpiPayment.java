package com.finzly.bbcubp.util;

import java.util.Set;

import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.CreditCard;
import com.finzly.bbcubp.model.Upi;

public class UpiPayment {
	private double amount;
    private Upi upi;
    public UpiPayment(double amount, Upi upi, Set<Bill> bills) {
		super();
		this.amount = amount;
		this.upi = upi;
		this.bills = bills;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Upi getUpi() {
		return upi;
	}
	public void setUpi(Upi upi) {
		this.upi = upi;
	}
	public Set<Bill> getBills() {
		return bills;
	}
	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
	private Set<Bill> bills;
}
