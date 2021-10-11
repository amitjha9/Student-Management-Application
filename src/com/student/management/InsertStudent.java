package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertStudent {

	boolean flag=false;
	Connection con;

	//Method to insert into student_manage table
	public boolean insertStudent(int sRollNo,int sAge,String sName,String sCity,String sPhone,String sDivision)
	{
		try {
			con=CreateConnection.createConnection();
			String query="insert into student_manage(sroll,sage,sname,scity,sphone,sdivision) values(?,?,?,?,?,?);";
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(query);
			//Set the value in prepared statement to insert into database
			pstmt.setString(1, Integer.toString(sRollNo));
			pstmt.setString(2, Integer.toString(sAge));
			pstmt.setString(3, sName);
			pstmt.setString(4, sCity);
			pstmt.setString(5, sPhone);
			pstmt.setString(6, sDivision);

			//Execute the query
			pstmt.executeUpdate();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//use finally to close the connection
		finally {
			try {
				if(con!=null)
				{
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
}
