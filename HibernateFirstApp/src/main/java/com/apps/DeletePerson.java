package com.apps;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entites.Person;

import jakarta.persistence.TypedQuery;

public class DeletePerson {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Person ID : ");
		int pno = sc.nextInt();
				
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sfact = cfg.buildSessionFactory();
		Session  sessionObj = sfact.openSession();
		Transaction trans = sessionObj.beginTransaction();

		TypedQuery qry = sessionObj.createQuery("Delete from Person where pid=:p");
		qry.setParameter("p", pno);
		qry.executeUpdate();
		
		trans.commit();
		
		System.out.println("Person is deleted...");
	}
}
