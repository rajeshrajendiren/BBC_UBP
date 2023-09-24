package com.finzly.bbcubp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.finzly.bbcubp.dao.BillPaymentDao;
import com.finzly.bbcubp.model.Customer;
import com.finzly.bbcubp.util.MailSenderService;
import com.finzly.bbcubp.util.OtpGenerator;

@Service
public class CustomerService {
	BillPaymentDao billPaymentDao;
	MailSenderService mailSenderService;

@Autowired
public CustomerService(BillPaymentDao billPaymentDao, OtpGenerator otpGenerator, MailSenderService mailSenderService) {
		super();
		this.billPaymentDao = billPaymentDao;
		this.otpGenerator = otpGenerator;
		this.mailSenderService=mailSenderService;
	}
OtpGenerator otpGenerator ;
	public String sendOTP(long customerId) {
		
		String generatedOtp = otpGenerator.generateOTP();	
		Customer customer=billPaymentDao.isCustomerExist(customerId);
		
		if(customer !=null) {
			String mail=customer.getEmail();
			customer.setOtp(generatedOtp);
			if(billPaymentDao.updateCustomerWithOtp(customer)) {
				mailSenderService.sendMail(mail, "otp", generatedOtp);
				return generatedOtp;
			}
			}
		return "";
	}
	public ResponseEntity<Map<String, Object>> loginCustomer(long customerId, String otp) {
		Map<String, Object> response = new HashMap<>();
		Customer customer = billPaymentDao.isCustomerExist(customerId);

		if (customer != null) {

			if (otp != null && otp.equals(customer.getOtp())) {
				customer.setOtp(null);
				billPaymentDao.updateCustomerWithOtp(customer);

				response.put("isValid", true);
				response.put("customer", customer);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.put("isValid", false);
				return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
			}
		} else {

			response.put("isValid", false);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

}
