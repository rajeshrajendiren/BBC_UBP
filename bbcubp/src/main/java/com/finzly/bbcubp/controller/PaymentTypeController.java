package com.finzly.bbcubp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.CreditCard;
import com.finzly.bbcubp.model.DebitCard;
import com.finzly.bbcubp.model.Upi;
import com.finzly.bbcubp.service.PaymentTypeService;
import com.finzly.bbcubp.util.CreditCardPayment;
import com.finzly.bbcubp.util.DebitCardPayment;
import com.finzly.bbcubp.util.UpiPayment;
import com.finzly.bbcubp.util.WalletPayment;

@CrossOrigin
@RestController
@RequestMapping("pay")
public class PaymentTypeController {
	private PaymentTypeService paymentTypeService;
	@Autowired
	public PaymentTypeController(PaymentTypeService paymentTypeService) {
		super();
	this.paymentTypeService = paymentTypeService;
	}
	
	@PostMapping("/creditcard/{cusId}")
	public String creditCardMethod(@PathVariable long cusId, @RequestBody CreditCardPayment creditCard) {
		
		paymentTypeService.creditCardMethod(cusId, creditCard.getBills(), creditCard.getCreditCard(),creditCard.getAmount());
		return "success";
	}
	@PostMapping("/debitcard/{cusId}")
	public String debitCardMethod(@PathVariable long cusId,@RequestBody DebitCardPayment debitCard) {
		paymentTypeService.debitCardMethod(cusId, debitCard.getBills(), debitCard.getDebitCard(),debitCard.getAmount());
		return "success";
	}
	@PostMapping("/wallet/{cusId}")
	public String walletMethod(@PathVariable long cusId,@RequestBody WalletPayment wallet) {
		 paymentTypeService.walletMethod(cusId, wallet.getBills(),wallet.getWallet(),wallet.getAmount());
		return "success";
	}
	@PostMapping("/upiid/{cusId}")
	public String upiMethod(@PathVariable long cusId,@RequestBody UpiPayment upi) {
		paymentTypeService.upiMethod(cusId, upi.getBills(),upi.getUpi(),upi.getAmount());
		return "success";
	}
	

}
