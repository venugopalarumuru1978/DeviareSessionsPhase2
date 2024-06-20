package com.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entites.Person;

import jakarta.persistence.TypedQuery;
import java.util.*;
public class ShowAllPersons {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sfact = cfg.buildSessionFactory();
		Session  sessionObj = sfact.openSession();
		
		TypedQuery qry = sessionObj.createQuery("from Person");
		
		List<Person>  personlist =  qry.getResultList();
		
		for(Person p : personlist)
		{
			System.out.println(p.getPid() + "\t" + p.getPersonName() + "\t" + p.getEmailId() + "\t" + p.getPhone());
		}
	}
}
