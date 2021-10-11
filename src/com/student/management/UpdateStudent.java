package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStudent {
	
	Connection con;
	boolean flag=false;
	
	//This method is used for updating table only one record at a time
	public boolean updateStudent(int studentID,String newData,String sqlQuery)
	{
		try {
			con=CreateConnection.createConnection();
			//Prepared Statement
			PreparedStatement pstmt=con.prepareStatement(sqlQuery);
			//Set the value in prepared statement to update
			pstmt.setString(1, newData);
			pstmt.setString(2, Integer.toString(studentID));
			
			//Execute the query
			pstmt.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//This method is used for updating table only one record at a time
	public boolean updateAllRecordStudent(int sid,int roll,int age,String name,String city,String phone,String saction)
	{
		boolean flag = false;
		Connection con;
		try {
			con=CreateConnection.createConnection();
			//Prepared Statement
			String query= "update student_manage set sroll=?,sage=?,sname=?,scity=?,sphone=?,sdivision=? where sid=?;";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			//Set the value in prepared statement parameter
			pstmt.setString(1, Integer.toString(roll));
			pstmt.setString(2, Integer.toString(age));
			pstmt.setString(3, name);
			pstmt.setString(4, city);
			pstmt.setString(5, phone);
			pstmt.setString(6, saction);
			pstmt.setString(7, Integer.toString(sid));
			//Execute the query
			pstmt.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
