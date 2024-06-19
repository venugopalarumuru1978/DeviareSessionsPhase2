package com.jdbcs;
import java.sql.*;
import java.util.*;

public class SearchBasedRollno {

	public static void main(String[] args) {

		Scanner  sc = new Scanner(System.in);
		
		System.out.println("Roll Number ");
		int rno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/deviaredb4","root","root");

			PreparedStatement  psObj = conObj.prepareStatement("select * from student where rollno=?");
			psObj.setInt(1, rno);
			
			ResultSet  rsObj = psObj.executeQuery();
			
			if(rsObj.next())
			{
				System.out.println("Roll Number : " + rsObj.getInt("rollno"));
				System.out.println("Student Name : " + rsObj.getString("stdname"));
				System.out.println("Student Name : " + rsObj.getString("course"));
				System.out.println("Student Name : " + rsObj.getFloat("fees"));
			}
			else
				System.out.println("Student Not Found with given roll number");
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
