package com.finzly.bbcubp.dao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.finzly.bbcubp.model.Bill;
import com.finzly.bbcubp.model.Customer;
@Repository
public class BillPaymentDao {
	private SessionFactory sessionFactory;

	public BillPaymentDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	 
	
	
	public Customer fetchAllcustomers(long customerId) {
	    try (Session session = sessionFactory.openSession()) {
	        Customer customer=session.get(Customer.class, customerId);
	        session.close();
	        return customer;
	    }
	}



	public List<Bill> fetchCustomerBills(long customerId) {
		// TODO Auto-generated method stub
		try (Session session = sessionFactory.openSession()) {
	        Customer customer=session.get(Customer.class, customerId);
	        List<Bill> bills=customer.getBills();
	        return bills;
	    }
	
	}

	public Bill fetchBillById(long billId) {
		// TODO Auto-generated method stub
		try (Session session = sessionFactory.openSession()) {
	        Bill bill = session.get(Bill.class, billId);
	        session.close();
	        return bill;
	    }
	
	}


	public List<Bill> fetchPaidBills(long customerId) {
		 
		try (Session session = sessionFactory.openSession()) {
	        Customer customer=session.get(Customer.class, customerId);
	        List<Bill> bills=customer.getBills();
	        List<Bill> paidBills=new ArrayList<>();
	        for(int i=0;i<bills.size();i++) {
	        if(bills.get(i).isPaid()) {
	        	paidBills.add(bills.get(i));
	        }
	      
	        
	    }
	        return paidBills;
	}
	
	 
	}
	public List<Bill> fetchUnPaidBills(long customerId) {
		 
		try (Session session = sessionFactory.openSession()) {
	        Customer customer=session.get(Customer.class, customerId);
	        List<Bill> bills=customer.getBills();
	        System.out.println("1");
	        List<Bill> UnPaidBills=new ArrayList<>();
	        for(int i=0;i<bills.size();i++) {
	        if(!bills.get(i).isPaid()) {
	        	System.out.println("1");
	        	UnPaidBills.add(bills.get(i));
	        }
	      
	        
	    }
	        return UnPaidBills;
	}
	
	 
	}
	public boolean updateBills(Bill bill) {
		try (Session session = sessionFactory.openSession()) {
	      session.update(bill);
	      session.beginTransaction().commit();
	      session.close();
	      
	      }
		return true;
	        
	    }
	        
	public Customer isCustomerExist(long id) {
		try (Session session = sessionFactory.openSession()) {
	        Customer customer = session.get(Customer.class, id);
	        session.close();
	        return customer;
	    }
	}
	public boolean updateCustomerWithOtp(Customer customer) {
		try (Session session = sessionFactory.openSession()) {
	        session.update(customer);
	        session.beginTransaction().commit();
	        session.close();
	        return true;
	    }
		
	}
		
	}
	
	



