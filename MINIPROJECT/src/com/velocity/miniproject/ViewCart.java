package com.velocity.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewCart extends BuyProduct{
	public void getViewcart() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		PurchaseItem purchaseItem=new PurchaseItem();
		Scanner scanner=new Scanner(System.in);
		int productid=super.pid;
		int quantity=super.pquantity;
		String uname=super.username;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
			preparedStatement=connection.prepareStatement("select * from cart where productId=? and quantity=?");
			preparedStatement.setInt(1, productid);
			preparedStatement.setInt(2, quantity);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Username="+resultSet.getString(1));
				System.out.println("Product Id="+resultSet.getInt(2));
				System.out.println("Quantity="+resultSet.getInt(3));
				System.out.println("Price="+resultSet.getString(4));
			}
			purchaseItem.getPurchaseItem();
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
