package com.finzly.bbcubp.service;




import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.finzly.bbcubp.dao.PaymentTypeDao;
import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.CreditCard;
import com.finzly.bbcubp.model.DebitCard;
import com.finzly.bbcubp.model.Upi;
import com.finzly.bbcubp.model.Wallet;
import com.finzly.bbcubp.util.PaymentType;
@Service
public class PaymentTypeService {
@Autowired
public PaymentTypeService(PaymentTypeDao paymentTypeDao) {
		super();
		this.paymentTypeDao = paymentTypeDao;
	}
private PaymentTypeDao paymentTypeDao;
 
	public String creditCardMethod(long cusId, Set<Bill> bills,CreditCard creditCard,double amount) {
		if(isValidCardNumber(creditCard.getCreditCardNumber())
				&&isValidCvv(creditCard.getCvv())
				&&isValidExpiryDate(creditCard.getExpiryDate())
				&&isValidName(creditCard.getCardHolderName())){
		paymentTypeDao.creditCardMethod( creditCard.getCreditCardNumber(),creditCard.getCardHolderName(),amount);
		
		paymentTypeDao.saveBill(cusId, bills,PaymentType.CREDIT_CARD);
		return "paid successfull";
	}
		return "else";
}
	
	
	public String debitCardMethod(long cusId,Set<Bill> bills,DebitCard debitCard,double amount) {
		if(isValidCardNumber(debitCard.getDebitCardNumber())
				&&isValidCvv(debitCard.getCvv())
				&&isValidExpiryDate(debitCard.getExpiryDate())
				&&isValidName(debitCard.getCardHolderName())){
		
			paymentTypeDao.debitCardMethod(debitCard.getDebitCardNumber(),debitCard.getCardHolderName(),amount);
			return paymentTypeDao.saveBill(cusId, bills, PaymentType.DEBIT_CARD);
	}
		return null;
	

}
	public String walletMethod(long cusId, Set<Bill> bills,Wallet wallet,double amount) {
		if(!(wallet.equals(null))){
		paymentTypeDao.walletMethod(wallet,amount);
		return paymentTypeDao.saveBill(cusId, bills, PaymentType.WALLET);
		}else {
			return "invalid walletId";
		}

}

	private boolean isValidName(String cardHolderName) {
		if(cardHolderName.matches("^[a-zA-Z-'\\s]+$")) {
			System.out.println("4");
			return true;
			}
		else {
			return false;
		}
	}

	private boolean isValidExpiryDate(String expiryDate) {
		try {
            //YearMonth yearMonth = YearMonth.parse(expiryDate);
            //YearMonth currentYearMonth = YearMonth.now();
			System.out.println("3");
            return true;
            		//yearMonth.isAfter(currentYearMonth);
        } catch (Exception e) {
            return false;
        }
		
	}

	private boolean isValidCvv(int cvv) {
	String cvvNumber=String.valueOf(cvv);
	if(cvvNumber.length()==4 || cvvNumber.length()==3) {
		System.out.println("2");
		return true;
		}
	else {
		return false;
	}
	}
	

	private boolean isValidCardNumber(String creditCardNumber) {
		if(creditCardNumber.length()==16) {
			System.out.println("1");
			return true;
			}
		else {
			return false;
		}
	}
	public String upiMethod(long cusid, Set<Bill> bills,Upi upi,double amount) {
		if(upi.getUpiId().matches("@[a-zA-Z0-9_]+\\.[a-zA-Z0-9_]+")) {
		paymentTypeDao.upiMethod(upi,amount);
		return paymentTypeDao.saveBill(cusid, bills, PaymentType.BANK_TRANSFER);
	}
	else {
		return "invalid upi Id";
	}
}}
