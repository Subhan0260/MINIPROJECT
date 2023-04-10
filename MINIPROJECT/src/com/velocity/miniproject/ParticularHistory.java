package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ParticularHistory {
	public void getParticularHistory() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int bill=0;
		try {
			System.out.println("Enter Username to check History>>");
			Scanner scanner=new Scanner(System.in);
			String uname=scanner.next();
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
			preparedStatement=connection.prepareStatement("select * from cart where username=?");
			preparedStatement.setString(1, uname);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Username="+resultSet.getString(1));
				System.out.println("Product Id="+resultSet.getInt(2));
				System.out.println("Quantity="+resultSet.getInt(3));
				System.out.println("Price="+resultSet.getString(4));
				bill=bill+resultSet.getInt("price");
			}
			System.out.println("Total Bill="+bill);
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
