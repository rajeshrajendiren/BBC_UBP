package com.finzly.bbcubp.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.finzly.bbcubp.util.PaymentType;


@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long paymentId;

	private LocalDate paymentDate;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", unique = true)
    private Bill bill;

	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	


	public Payment() {
		super();
	}

	public Payment(long paymentId, LocalDate paymentDate, PaymentType paymentType) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}



}
