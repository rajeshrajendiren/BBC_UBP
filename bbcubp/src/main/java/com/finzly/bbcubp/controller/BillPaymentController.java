package com.finzly.bbcubp.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.Customer;
import com.finzly.bbcubp.model.PaymentTransaction;
import com.finzly.bbcubp.service.BillPaymentService;

@CrossOrigin()
@RestController
public class BillPaymentController {
	private BillPaymentService billPaymentService;

	@Autowired
	public BillPaymentController(BillPaymentService billPaymentService) {
		super();
		this.billPaymentService = billPaymentService;
	}

	@GetMapping("/fetch-customer-with-bills/{customerId}")
	public Customer fetchAllCustomers(@PathVariable long customerId) {
		return billPaymentService.fetchAllCustomers(customerId);
	}

	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/fetch-customer-bills/{customerId}")
	public List<Bill> fetchCustomerBills(@PathVariable long customerId) {
		return billPaymentService.fetchCustomerBills(customerId);
	}

	@GetMapping("/fetch-unpaid-bills/{customerId}")
	public List<Bill> fetchUnPaidBills(@PathVariable long customerId) {
		

		return billPaymentService.fetchUnPaidBills(customerId);

	}

	@GetMapping("/fetch-paid-bills/{customerId}")
	public List<Bill> fetchPaidBills(@PathVariable long customerId) {
		

		return billPaymentService.fetchPaidBills(customerId);

	}
	@GetMapping("/get-by-customer/{customerId}")
	public List<PaymentTransaction>getTrasactionsByCustomer(@PathVariable long customerId){
		return billPaymentService.getTrasactionsByCustomer(customerId);
	}
	
	@GetMapping("/get-customer/{cusId}")
	public Customer getCustomer(@PathVariable long cusId) {
		return billPaymentService.getCustomer(cusId);
			
		}
	}



