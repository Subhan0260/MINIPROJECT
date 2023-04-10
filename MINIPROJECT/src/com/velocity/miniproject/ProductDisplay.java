package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDisplay extends LogIn {
	String username=super.uname;
	String password=super.pass;
	public void getProductList() throws SQLException {
		BuyProduct buyProduct=new BuyProduct();
		UserStory userStory=new UserStory();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
			preparedStatement=connection.prepareStatement("select * from product");
			resultSet=preparedStatement.executeQuery();
			int count=0;
			while(resultSet.next()) {
				count++;
				System.out.println("Product Id="+resultSet.getInt(1));
				System.out.println("Product Name="+resultSet.getString(2));
				System.out.println("Product Description="+resultSet.getString(3));
				System.out.println("Product Quantity="+resultSet.getInt(4));
				System.out.println("Price="+resultSet.getInt(5));
			}
			if(count>0) {
				System.out.println(""
						+ "");
				buyProduct.getBuyProduct();
			}
			else {
				userStory.getUserStoryDetails();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}
}
