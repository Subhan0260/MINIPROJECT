package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminAddProduct {
	public void getAdminAddProduct() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			Scanner scanner=new Scanner(System.in);
				System.out.println("Enter Product Name");
				String pname=scanner.next();
				System.out.println("Enter Description");
				String des=scanner.next();
				System.out.println("Enter Quantity");
				int quantity=scanner.nextInt();
				System.out.println("Enter Price");
				int price=scanner.nextInt();
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","root");
				preparedStatement=connection.prepareStatement("insert into product(productName,productDescription,quantity,price)values(?,?,?,?)");
				preparedStatement.setString(1,pname);
				preparedStatement.setString(2,des);
				preparedStatement.setInt(3,quantity);
				preparedStatement.setInt(4,price);
				preparedStatement.executeUpdate();
				System.out.println("Product Successfully Added>>>");
	}catch(Exception e){
		System.out.println(e);
	}finally {
		connection.close();
		preparedStatement.close();
	}
}
}
