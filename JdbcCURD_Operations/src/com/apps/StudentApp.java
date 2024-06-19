package com.apps;
import java.util.*;

import com.entities.Student;
import com.operations.StudentOperations;
public class StudentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student std = null;
		StudentOperations  so = new StudentOperations();
		
		while(true)
		{
			System.out.println("1. New Student\n2. View All Students\n3. Search Student\n4. Update Student\n5. Delete Student\n6. Exit");
			System.out.println("Pick Ur Choice ");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
				// add new student functionality
				std = new Student();
				System.out.println("Roll Number : ");
				std.setRollno(sc.nextInt());
				
				System.out.println("Student Name : ");
				std.setStdname(sc.next());
				
				System.out.println("Student Course : ");
				std.setCourse(sc.next());
				
				System.out.println("Course Fees ");
				std.setFees(sc.nextFloat());
				
				so.AddStudent(std);
				System.out.println("New Student is Added...");
				break;
			case 2:
				//view all students functionality
				List<Student>  stdlistinfo = so.ShowAll();
				for(Student s : stdlistinfo)
				{
					System.out.println(s.getRollno() + "\t" + s.getStdname() + "\t" + s.getCourse() + "\t" + s.getFees());
				}
				break;
			case 3:
				System.out.println("Roll Number : ");
				int rno = sc.nextInt();
				Student sinfo = so.SearchStudent(rno);
				if(sinfo!=null)
				{
					System.out.println(sinfo.getRollno() + "\t" + sinfo.getStdname() + "\t" + sinfo.getCourse() + "\t" + sinfo.getFees());
				}
				else
					System.out.println("No student exist with given rollnumber ");
				break;
			case 4:
				System.out.println("Roll Number : ");
				rno = sc.nextInt();
				std = so.SearchStudent(rno);
				if(std!=null)
				{
					System.out.println("Present Name of the Student : " + std.getStdname());
					System.out.println("Enter new name of the Student : ");
					std.setStdname(sc.next());
					so.UpdateStudent(std);
					System.out.println("Student Name updated...");
				}
				else
					System.out.println("No student exist with given rollnumber ");
				break;
			case 5:
				System.out.println("Roll Number : ");
				rno = sc.nextInt();
				std = so.SearchStudent(rno);
				if(std!=null)
				{
					System.out.println(std.getRollno() + "\t" + std.getStdname() + "\t" + std.getCourse() + "\t" + std.getFees());
					System.out.println("Are u sure to delete(y/n) ");
					String chk = sc.next();
					if(chk.equalsIgnoreCase("y"))
					{
						so.DeleteStudent(rno);
						System.out.println("Student deleted");
					}
				}
				else
					System.out.println("No student exist with given rollnumber ");
				break;				
			case 6:
				System.out.println("Thanks for using this app");
				System.exit(0);
			}
		}	
	}
}
