package com.jdbcs;
import java.sql.*;
public class ViewAllRows {
// View All Rows
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/deviaredb4","root","root");

			Statement stmtView =  conObj.createStatement();
			
			ResultSet  rsStdInfo = stmtView.executeQuery("select * from student");
			
			while(rsStdInfo.next())
			{
				System.out.println("Roll Number : " + rsStdInfo.getInt("rollno"));
				System.out.println("Student Name : " + rsStdInfo.getString("stdname"));
				System.out.println("Student Name : " + rsStdInfo.getString("course"));
				System.out.println("Student Name : " + rsStdInfo.getFloat("fees"));
				System.out.println("---------------");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
