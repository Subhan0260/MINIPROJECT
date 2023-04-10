package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckQuantity {
	public void getQuantity() throws SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product Id to get Product Quantity");
		int pid=scanner.nextInt();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
			preparedStatement=connection.prepareStatement("select quantity from product where productId=?");
			preparedStatement.setInt(1, pid);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Product Quantity>>"+resultSet.getInt("quantity"));
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
