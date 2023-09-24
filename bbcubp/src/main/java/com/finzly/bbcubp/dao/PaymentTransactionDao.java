package com.finzly.bbcubp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.bbcubp.model.PaymentTransaction;

@Repository
public class PaymentTransactionDao {
@Autowired
private SessionFactory sessionFactory;
	public List<PaymentTransaction> getTransactionsByCustomer(long customerId) {
		
	        Session session = sessionFactory.openSession();
	        try {
	            Criteria criteria = session.createCriteria(PaymentTransaction.class)
	                .createAlias("customer", "c")
	                .add(Restrictions.eq("c.customerId", customerId));
	            return criteria.list();
	        } finally {
	            session.close();
	        }
	    }
	}


