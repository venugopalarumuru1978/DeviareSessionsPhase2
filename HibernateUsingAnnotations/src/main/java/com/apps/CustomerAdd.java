package com.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Customer;

public class CustomerAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sfact = cfg.buildSessionFactory();
		Session  sessionObj = sfact.openSession();
		Transaction trans = sessionObj.beginTransaction();
		
		Customer cus = new Customer();
		
		//cus.setCid(11);
		cus.setCurname("Bhavani");
		cus.setLocation("Hyderabad");
		
		sessionObj.persist(cus);
		trans.commit();
		
		System.out.println("New Customer is created...");
		
	}

}
