package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
	public void getRegistration() throws SQLException {
		UserStory userStory=new UserStory();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter First Name");
			String fname=scanner.next();
			System.out.println("Enter Last Name");
			String lname=scanner.next();
			System.out.println("Enter Username");
			String uname=scanner.next();
			System.out.println("Enter password");
			String pass=scanner.next();
			System.out.println("Enter City");
			String city=scanner.next();
			System.out.println("Enter E-mail");
			String email=scanner.next();
			System.out.println("Enter Mobile");
			String mobile=scanner.next();
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
			preparedStatement=connection.prepareStatement("insert into registration(firstName,lastName,username,passwords,city,email,mobile)values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1,fname);
			preparedStatement.setString(2,lname);
			preparedStatement.setString(3,uname);
			preparedStatement.setString(4,pass);
			preparedStatement.setString(5,city);
			preparedStatement.setString(6,email);
			preparedStatement.setString(7,mobile);
			preparedStatement.executeUpdate();
			System.out.println("Registration Successfull>>");
			userStory.getUserStoryDetails();
		}catch(Exception e){
			System.out.println(e);
		}finally {
			connection.close();
			preparedStatement.close();
			
		}
	}
}
