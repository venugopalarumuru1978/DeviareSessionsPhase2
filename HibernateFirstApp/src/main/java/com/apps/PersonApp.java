package com.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entites.Person;

public class PersonApp {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sfact = cfg.buildSessionFactory();
		Session  sessionObj = sfact.openSession();
		Transaction trans = sessionObj.beginTransaction();
		
		Person per = new Person();
		
		//per.setPid(1002);
		per.setPersonName("Pravasthi");
		per.setEmailId("pravasthi@gmail.com");
		per.setPhone("9098123452");
		
		sessionObj.persist(per);
		trans.commit();
		
		System.out.println("New Person is Created...");
	}
}
