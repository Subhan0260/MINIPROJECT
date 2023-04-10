package com.velocity.miniproject2;

import java.sql.SQLException;
import java.util.Scanner;

public class UserStory {
	public static void getUserStoryDetails() throws SQLException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome to E-commerce based application");
		System.out.println(""
				+ "");
		System.out.println("User Operation");
		System.out.println(""
				+ "");
		System.out.println("1. User Registration");
		System.out.println("2. User Login");
		System.out.println("3. User view Product item as Sorted Order");
		System.out.println("4. Buy Product");
		System.out.println("5. View Cart");
		System.out.println("6. Purchase the item");
		System.out.println(""
				+ "");
		System.out.println("Admin Operation");
		System.out.println(""
				+ "");
		System.out.println("7. Add Product item");
		System.out.println("8. Calculate Bill");
		System.out.println("9. Display amount to End User");
		System.out.println("10.Check Quntity");
		System.out.println("11.Check Registered User");
		System.out.println("12.Check the particular user history");
		System.out.println(""
				+ "");
		System.out.println("Guest Operation");
		System.out.println(""
				+ "");
		System.out.println("13.View product item");
		System.out.println("14.Not purchase item");
		System.out.println(""
				+ "");
		System.out.println("Enter Your Choice>>");
		int choice=scanner.nextInt();
		UserChoice userChoice=new UserChoice();
		userChoice.getUserChoice(choice);
	}
}
