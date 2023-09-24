package com.finzly.bbcubp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Upi {
@Id
private String upiId;
private double balance;
public String getUpiId() {
	return upiId;
}
public void setUpiId(String upiId) {
	this.upiId = upiId;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

}
