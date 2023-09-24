package com.finzly.bbcubp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.bbcubp.model.Customer;
import com.finzly.bbcubp.service.CustomerService;

@CrossOrigin
@RestController
public class OTPcontroller {
	CustomerService customerService;
	@Autowired
	public OTPcontroller(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/get-opt/{customerId}")
	public String loginCustomer(@PathVariable long customerId){
		return customerService.sendOTP(customerId);
	}
	
	
	@PostMapping("/login/verify")
	public ResponseEntity<Map<String, Object>> verifyOtp(@RequestBody Customer customer) {
		long customerId = customer.getCustomerId();
		String otp = customer.getOtp();
		return customerService.loginCustomer(customerId, otp);
	}

	

}
