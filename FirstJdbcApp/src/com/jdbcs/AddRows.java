package com.jdbcs;
import java.sql.*;
public class AddRows {
// adding rows
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/deviaredb4","root","root");
			// how to generate Insert command here
			
			Statement stmtInsert = conObj.createStatement();
			
			stmtInsert.executeUpdate("Insert into student(rollno, stdname, course, fees) values(1008, 'Pravasthi', 'Python', 30000.00)");
			
			System.out.println("New Student is added....");
						
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
