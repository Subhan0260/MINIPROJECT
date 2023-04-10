package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BuyProduct extends LogIn{
	String username=super.uname;
	int price=0;
	public static int pid;
	public static int pquantity;
	public void getBuyProduct()throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product-Id to Buy Product");
		pid=scanner.nextInt();
		System.out.println("Enter Product Quantity");
		pquantity=scanner.nextInt();
		try {
			
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
				preparedStatement=connection.prepareStatement("select price from product where productId=?");
				preparedStatement.setInt(1, pid);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					price=resultSet.getInt("price");
					price=price*pquantity;
				}
					preparedStatement=connection.prepareStatement("insert into cart(username,productId,quantity,price)values(?,?,?,?)");
					preparedStatement.setString(1,username);
					preparedStatement.setInt(2,pid);
					preparedStatement.setInt(3,pquantity);
					preparedStatement.setInt(4,price);
					preparedStatement.executeUpdate();
					System.out.println("Do you want to view Cart Yes/No");
					String result=scanner.next();
					if(result.equals("Yes")) {
						ViewCart viewCart=new ViewCart();
						viewCart.getViewcart();
					}
					else if(result.equals("No")){
						UserStory userStory=new UserStory();
						userStory.getUserStoryDetails();
					}
					else {
						System.out.println("Invalid Input");
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
