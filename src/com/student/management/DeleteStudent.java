package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudent {
	
	Connection con;
	boolean flag=false;
	public boolean deleteStudent(int studentID)
	{
		try {
			//Create connection
			con=CreateConnection.createConnection();
			//Prepared Statement
			String query= "delete from student_manage where sid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//Set the value in prepared statement
			pstmt.setString(1, Integer.toString(studentID));
			
			//Execute query
			pstmt.execute();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
