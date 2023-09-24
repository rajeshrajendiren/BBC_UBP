package com.finzly.bbcubp.dao;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.CreditCard;
import com.finzly.bbcubp.model.DebitCard;
import com.finzly.bbcubp.model.PaymentTransaction;
import com.finzly.bbcubp.model.Upi;
import com.finzly.bbcubp.model.Wallet;
import com.finzly.bbcubp.util.PaymentType;

@Repository
public class PaymentTypeDao {
	SessionFactory sessionFactory;
	private final BillPaymentDao billPaymentDao;

	@Autowired
	public PaymentTypeDao(SessionFactory sessionFactory, BillPaymentDao billPaymentDao) {
		super();
		this.sessionFactory = sessionFactory;
		this.billPaymentDao = billPaymentDao;
	}

	public String upiMethod(Upi upi, double amount) {

		Session session = sessionFactory.openSession();

		Upi upivar = session.get(Upi.class, upi.getUpiId());

		if (upi != null && upi.getUpiId().equals(upi.getUpiId()) && upi.getBalance() <= amount) {
			double remainingBalance = upi.getBalance() - amount;
			upi.setBalance(remainingBalance);
			session.update(upi);
			session.beginTransaction().commit();
			session.close();

			return "Amount Paid successfully";

		} else {
			return "insufficient balance";
		}

	}

	public String walletMethod(Wallet wallet, double amount) {
		Session session = sessionFactory.openSession();

		Wallet walletvar = session.get(Wallet.class, wallet.getWalletId());

		if (wallet != null && wallet.equals(wallet.getWalletId()) && wallet.getCashAmount() <= amount) {
			double remainingBalance = wallet.getCashAmount() - amount;
			wallet.setCashAmount(amount);
			session.update(wallet);
			session.beginTransaction().commit();
			session.close();

			return "Amount Paid successfully";

		} else {
			return "insufficient balance";
		}

	}

	public String creditCardMethod(String creditCardNumber, String cardHolderName, double amount) {
		Session session = sessionFactory.openSession();

		CreditCard creditCard = session.get(CreditCard.class, creditCardNumber);

		if (creditCard != null && cardHolderName.equals(creditCard.getCardHolderName())) {
			double remainingLimit = creditCard.getCashLimit() - amount;
			creditCard.setCashLimit(remainingLimit);
			session.update(creditCard);
			session.beginTransaction().commit();
			session.close();

			return "Amount Paid successfully";

		} else {
			return "you exceed your limits";
		}
	}

	public String debitCardMethod(String debitCardNumber, String cardHolderName, double amount) {
		Session session = sessionFactory.openSession();

		DebitCard debitCard = session.get(DebitCard.class, debitCardNumber);

		if (debitCard != null && cardHolderName.equals(debitCard.getCardHolderName())
				&& debitCard.getAmount() <= amount) {
			double remainingBalance = debitCard.getAmount() - amount;
			debitCard.setAmount(remainingBalance);
			session.update(debitCard);
			session.beginTransaction().commit();
			session.close();

			return "Amount Paid successfully";

		} else {
			return "you exceed your limits";
		}
	}

	public String saveBill(long cusId, Set<Bill> bills, PaymentType paymentMethod) {
		Session session = sessionFactory.openSession();

		for (Bill bill : bills) {

			if (bill != null) {
				if (bill.getPaymentTransaction() == null) {
					PaymentTransaction paymentTransaction = new PaymentTransaction();
					paymentTransaction.setTransactionDate(LocalDate.now());
					paymentTransaction.setAmount(checkDiscount(bill));
					paymentTransaction.setPaymentType(paymentMethod);
					paymentTransaction.setCustomer(billPaymentDao.isCustomerExist(cusId));
					paymentTransaction.setBill(bill);
					session.save(paymentTransaction);
					bill.setPaymentTransaction(paymentTransaction);
				}
				bill.setPaid(true);
				billPaymentDao.updateBills(bill);
//			return "transaction saved";
			}
		}
		return "transaction not saved";
	}

	private double checkDiscount(Bill bill) {

		LocalDate today = LocalDate.now();
		if (today.isBefore(bill.getBillDueDate()) && today.equals(bill.getBillDueDate())) {
			return bill.getAmountForBothDiscount();
		}

		else {
			return bill.getAmountForOnlinePay();
		}
	}

}
