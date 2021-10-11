package com.student.management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudent {

	Connection con;
	public void displayStudent()
	{
		try {
			//Create connection
			con=CreateConnection.createConnection();
			String query= "select * from student_manage;";
			//Since this query don't insert/update anything into the database, only retrieving the result so we will use Statement
			Statement stmt = con.createStatement();
			
			//Execute query
			ResultSet rs=stmt.executeQuery(query);
			//check if rs has any data
			while(rs.next())
			{
				System.out.println("SID: "+rs.getInt(1));
				System.out.println("ROLL NO: "+rs.getInt(2));
				System.out.println("AGE: "+rs.getInt(3));
				System.out.println("Name: "+rs.getString(4));
				System.out.println("City: "+rs.getString(5));
				System.out.println("PHONE: "+rs.getString(6));
				System.out.println("SACTION: "+rs.getString(7));
				System.out.println("+++++++++++++++++++++++++++");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
