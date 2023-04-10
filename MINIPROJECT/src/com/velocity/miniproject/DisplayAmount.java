package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayAmount {
	public void getDisplayAmount() throws SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Username to view Product and Total Amount");
		String uname=scanner.next();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int amount=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
			preparedStatement=connection.prepareStatement("select * from cart where username=?");
			preparedStatement.setString(1, uname);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Username="+resultSet.getString("username"));
				System.out.println("Product Id="+resultSet.getInt("productId"));
				System.out.println("Quantity="+resultSet.getInt("quantity"));
				amount=amount+resultSet.getInt("price");
			}
			System.out.println("Total Amount="+amount);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}
}
