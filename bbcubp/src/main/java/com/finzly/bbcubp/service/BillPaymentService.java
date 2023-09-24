package com.finzly.bbcubp.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.bbcubp.dao.BillPaymentDao;
import com.finzly.bbcubp.dao.PaymentTransactionDao;
import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.Customer;
import com.finzly.bbcubp.model.PaymentTransaction;
import com.finzly.bbcubp.util.MailSenderService;
@Service
public class BillPaymentService {
	private BillPaymentDao billPaymentDao;
	private MailSenderService mailSenderService;
	private PaymentTransactionDao paymentTransactionDao;
    @Autowired
	public BillPaymentService(BillPaymentDao billPaymentDao, MailSenderService mailSenderService,
			PaymentTransactionDao paymentTransactionDao) {
		super();
		this.billPaymentDao = billPaymentDao;
		this.mailSenderService = mailSenderService;
		this.paymentTransactionDao = paymentTransactionDao;
	}


	/*
	 * public List<Bill> fetchAllBills(long customerId) { // TODO Auto-generated
	 * method stub return billPaymentDao.fetchAllBills(customerId); }
	 */
	public Customer fetchAllCustomers(long customerId) {
		mailSenderService.sendMail("rajeshrajendiren2.o@gmail.com", "test1", "otp1");
		return billPaymentDao.fetchAllcustomers(customerId);
	}




	public List<Bill> fetchCustomerBills(long customerId) {
		// TODO Auto-generated method stub
		List<Bill> bills = billPaymentDao.fetchCustomerBills(customerId);
		bills.sort(Comparator.comparing(Bill::getDurationOfBill));
		
		return bills;
	}
	public List<Bill> fetchPaidBills(long customerId) {
		// TODO Auto-generated method stub
		List<Bill> paidBills=billPaymentDao.fetchPaidBills(customerId);
		paidBills.sort(Comparator.comparing(Bill::getDurationOfBill));
		
		return paidBills;
		
	
	}
	public List<Bill> fetchUnPaidBills(long customerId) {
		// TODO Auto-generated method stub
		List<Bill> UnPaidBills=billPaymentDao.fetchUnPaidBills(customerId);
		UnPaidBills.sort(Comparator.comparing(Bill::getDurationOfBill));
		
		return UnPaidBills;
		
	
	}


	public List<PaymentTransaction> getTrasactionsByCustomer(long customerId) {
		if(billPaymentDao.isCustomerExist(customerId) !=null) {
			return paymentTransactionDao.getTransactionsByCustomer(customerId);
			
			
		}else {return null;}
		
	}


	public Customer getCustomer(long cusId) {
		// TODO Auto-generated method stub
		return billPaymentDao.isCustomerExist(cusId);	}
		
	
}
	

