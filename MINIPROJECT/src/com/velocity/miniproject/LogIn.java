package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LogIn {
	public static  String uname;
	public static String pass;
	public void getLogin() throws SQLException {
		ProductDisplay productDisplay=new ProductDisplay();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Username>>");
		this.uname=scanner.next();
		System.out.println("Enter Password>>");
		this.pass=scanner.next();
		int count=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject2", "root", "root");
			preparedStatement=connection.prepareStatement("select username,passwords from registration");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				if(uname.equals(resultSet.getString("username")) && pass.equals(resultSet.getString("passwords"))) {	
					System.out.println("Successfully Login");
					count++;
				}
			}
			if(count>0) {
				productDisplay.getProductList();
			}
			if(count==0) {
				System.out.println("Something Went wrong");
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
