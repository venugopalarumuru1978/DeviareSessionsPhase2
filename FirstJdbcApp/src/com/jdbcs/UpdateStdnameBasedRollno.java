package com.jdbcs;
import java.sql.*;
import java.util.*;

public class UpdateStdnameBasedRollno {

	public static void main(String[] args) {

		Scanner  sc = new Scanner(System.in);
		
		System.out.println("Roll Number ");
		int rno = sc.nextInt();
		
		System.out.println("Student New Name ");
		String sname = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/deviaredb4","root","root");

			PreparedStatement  psObj = conObj.prepareStatement("update student set stdname=? where rollno=?");
			psObj.setString(1, sname);
			psObj.setInt(2, rno);
			
			int res = psObj.executeUpdate();
			
			if(res>=1)
				System.out.println(res + " row is Updated");
			else
				System.out.println("No Student is updated.. Roll Number not found...");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
