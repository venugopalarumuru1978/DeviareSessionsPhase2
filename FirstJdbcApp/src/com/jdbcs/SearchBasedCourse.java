package com.jdbcs;
import java.sql.*;
import java.util.*;

public class SearchBasedCourse {

	public static void main(String[] args) {

		Scanner  sc = new Scanner(System.in);
		
		System.out.println("Course Name ");
		String  curs = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/deviaredb4","root","root");

			PreparedStatement  psObj = conObj.prepareStatement("select * from student where course=?");
			psObj.setString(1, curs);
			
			ResultSet  rsObj = psObj.executeQuery();
		
			boolean chkData = false;
			
			while(rsObj.next())
			{
					chkData = true;
					System.out.println("Roll Number : " + rsObj.getInt("rollno"));
					System.out.println("Student Name : " + rsObj.getString("stdname"));
					System.out.println("Student Name : " + rsObj.getString("course"));
					System.out.println("Student Name : " + rsObj.getFloat("fees"));
					System.out.println("-------------------");
			}
			
			if(chkData==false)
				System.out.println("Students Not Found with given course");
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
