package com.finzly.bbcubp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
@Id
private Long walletId;
public Long getWalletId() {
	return walletId;
}
public void setWalletId( long walletId) {
	this.walletId = walletId;
}
public double getCashAmount() {
	return cashAmount;
}
public void setCashAmount(double cashAmount) {
	this.cashAmount = cashAmount;
}

public Wallet(Long walletId, double cashAmount) {
	super();
	this.walletId = walletId;
	this.cashAmount = cashAmount;
}
private double cashAmount;
}
