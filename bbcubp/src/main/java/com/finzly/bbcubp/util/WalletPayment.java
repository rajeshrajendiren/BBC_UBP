package com.finzly.bbcubp.util;

import java.util.Set;

import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.CreditCard;
import com.finzly.bbcubp.model.Wallet;

public class WalletPayment {
	private double amount;
    private Wallet wallet;
    public WalletPayment(double amount, Wallet wallet, Set<Bill> bills) {
		super();
		this.amount = amount;
		this.wallet = wallet;
		this.bills = bills;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public Set<Bill> getBills() {
		return bills;
	}
	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
	private Set<Bill> bills;
}
