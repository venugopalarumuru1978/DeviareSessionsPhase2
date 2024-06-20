package com.apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entites.Person;

import jakarta.persistence.TypedQuery;
import java.util.*;
public class SearchPerson {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person ID : ");
		int pno = sc.nextInt();
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sfact = cfg.buildSessionFactory();
		Session  sessionObj = sfact.openSession();
		
		TypedQuery qry = sessionObj.createQuery("from Person where pid=:p");
		qry.setParameter("p", pno);
		List<Person>  personlist =  qry.getResultList();
		
		if(personlist.isEmpty())
			System.out.println("No Person found with given number");
		else
		{
			Person p = personlist.get(0);
			System.out.println(p.getPid() + "\t" + p.getPersonName() + "\t" + p.getEmailId() + "\t" + p.getPhone());
		}
	}
}
