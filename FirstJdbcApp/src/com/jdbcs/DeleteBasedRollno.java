package com.jdbcs;
import java.sql.*;
import java.util.*;

public class DeleteBasedRollno {

	public static void main(String[] args) {

		Scanner  sc = new Scanner(System.in);
		
		System.out.println("Roll Number ");
		int rno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/deviaredb4","root","root");

			PreparedStatement  psObj = conObj.prepareStatement("delete from student where rollno=?");
			psObj.setInt(1, rno);
			
			int res = psObj.executeUpdate();
			
			if(res>=1)
				System.out.println(res + " row is deleted");
			else
				System.out.println("No Student is deleted.. Roll Number not found...");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
