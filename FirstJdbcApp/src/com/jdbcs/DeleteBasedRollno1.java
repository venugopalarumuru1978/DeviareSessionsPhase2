package com.jdbcs;
import java.sql.*;
import java.util.*;

public class DeleteBasedRollno1 {

	public static void main(String[] args) {

		Scanner  sc = new Scanner(System.in);
		
		System.out.println("Roll Number ");
		int rno = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/deviaredb4","root","root");

			conObj.setAutoCommit(false);
			
			PreparedStatement  psObj = conObj.prepareStatement("delete from student where rollno=?");
			psObj.setInt(1, rno);
			
			int res = psObj.executeUpdate();
			
			if(res>=1)
			{
				System.out.println("Are u sure to you want to delete(y/n) : ");
				String ch = sc.next();
				if(ch.equalsIgnoreCase("Y"))
				{
					conObj.commit();
					System.out.println(res + " row is deleted");	
				}
				else
				{
					conObj.rollback();
					System.out.println("Row not deleted");
				}
			}
			else
				System.out.println("No Student is deleted.. Roll Number not found...");
			
			conObj.close();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
