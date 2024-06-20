package com.apps;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entites.Person;

public class PersonAdd {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Person per = new Person();
		
		System.out.println("Person ID : ");
		per.setPid(sc.nextInt());
		
		System.out.println("Person Name : ");
		per.setPersonName(sc.next());
		
		System.out.println("Person Email : ");
		per.setEmailId(sc.next());
		
		System.out.println("Person Phone Number ");
		per.setPhone(sc.next());
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sfact = cfg.buildSessionFactory();
		Session  sessionObj = sfact.openSession();
		Transaction trans = sessionObj.beginTransaction();

		sessionObj.persist(per);
		trans.commit();
		
		System.out.println("New Person is Created...");
	}
}
