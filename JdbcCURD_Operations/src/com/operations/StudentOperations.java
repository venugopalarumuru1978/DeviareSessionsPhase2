package com.operations;
import java.sql.*;

import com.connections.DbConnection;
import com.entities.Student;
import java.util.*;
public class StudentOperations {

	private Connection conObj = null;
	private PreparedStatement psObj = null;
	
	public StudentOperations()
	{
		conObj = DbConnection.getConnection();
	}
	
	
	public int AddStudent(Student std)
	{
		int res = 0;
		try {
			psObj = conObj.prepareStatement("Insert into student(rollno, stdname, course, fees) values(?,?,?,?)");
			psObj.setInt(1, std.getRollno());
			psObj.setString(2, std.getStdname());
			psObj.setString(3, std.getCourse());
			psObj.setFloat(4, std.getFees());
			
			res = psObj.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			res = 0;
		}
		return res;
	}
	
	public List<Student> ShowAll()
	{
		List<Student>  stdlist = new ArrayList<Student>();
		Student std = null;
		try {
			psObj = conObj.prepareStatement("select * from student");
			ResultSet rsObj = psObj.executeQuery();
			
			while(rsObj.next())
			{
				std = new Student();
				std.setRollno(rsObj.getInt("rollno"));
				std.setStdname(rsObj.getString("stdname"));
				std.setCourse(rsObj.getString("course"));
				std.setFees(rsObj.getFloat("fees"));
				stdlist.add(std);	
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return stdlist;
	}
	
	public Student SearchStudent(int rno)
	{
		Student std = null;
		
		try {
			psObj = conObj.prepareStatement("select * from student where rollno=?");
			psObj.setInt(1, rno);
			ResultSet rsObj = psObj.executeQuery();
			
			if(rsObj.next())
			{
				std = new Student();
				std.setRollno(rsObj.getInt("rollno"));
				std.setStdname(rsObj.getString("stdname"));
				std.setCourse(rsObj.getString("course"));
				std.setFees(rsObj.getFloat("fees"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return std;
	}
	
	public int DeleteStudent(int rno)
	{
		int res =0;
		try {
			psObj = conObj.prepareStatement("Delete from student where rollno=?");
			psObj.setInt(1, rno);
			res = psObj.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public int UpdateStudent(Student std)
	{
		int res =0;
		try {
			psObj = conObj.prepareStatement("Update student set stdname = ? where rollno=?");
			psObj.setString(1, std.getStdname());
			psObj.setInt(2, std.getRollno());
			
			res = psObj.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return res;
	}
}
