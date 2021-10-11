package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

	public static Connection con;
	public static Connection createConnection()
	{
		try {
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			//Create the connection
			String userName="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/students";
			con=DriverManager.getConnection(url, userName, password);
			System.out.println("Connected to the database.....");
		} catch (Exception e) {
			System.out.println("Connection to the database failed......");
			e.printStackTrace();
		}
		return con;
	}
}
