package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckRegisteredUser {
	public void getRegiseredUser() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Username>>");
		String uname=scanner.next();
		System.out.println("Enter Password>>");
		String pass=scanner.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
			preparedStatement=connection.prepareStatement("select username,passwords from registration");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				if(uname.equals(resultSet.getString("username")) && pass.equals(resultSet.getString("passwords"))) {	
					System.out.println("You are Registered User");
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}
}
