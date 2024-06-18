package com.jdbcs;
import java.sql.*;
import java.util.Scanner;
public class AddRowsDynamically {
// adding rows dynamically
	public static void main(String[] args) {
		//Insert into student(rollno, stdname, course, fees) 
		//values(1008, 'Pravasthi', 'Python', 30000.00)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Roll Number : ");
		int rollNumber = sc.nextInt();
		
		System.out.println("Student Name : ");
		String stdName = sc.next();
		
		System.out.println("Student Course : ");
		String stdCourse = sc.next();
		
		System.out.println("Course Fees : ");
		float courseFees = sc.nextFloat();

		String inscmd = "Insert into student(rollno, stdname, course, fees) values(";
		inscmd = inscmd + rollNumber + ",'" + stdName + "','" + stdCourse + "'," + courseFees + ")";
		
		System.out.println(inscmd);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/deviaredb4","root","root");
			// how to generate Insert command here
			
			Statement stmtInsert = conObj.createStatement();
			
			stmtInsert.executeUpdate(inscmd);
			
			System.out.println("New Student is added....");
						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
