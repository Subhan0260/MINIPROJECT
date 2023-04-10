package com.velocity.miniproject2;

import java.sql.SQLException;
import java.util.Scanner;

public class UserChoice {
	public void getUserChoice(int choice) throws SQLException {
		LogIn logIn=new LogIn();
	switch(choice){
		case 1:
			Registration registration=new Registration();
			registration.getRegistration();
			break;
		case 2:
			logIn.getLogin();
			break;
		case 3:
			System.out.println("You have to login first");
			logIn.getLogin();
			break;
		case 4:
			System.out.println("You have to login first");
			logIn.getLogin();
			break;
		case 5:
			System.out.println("You have to login first");
			logIn.getLogin();
			break;
		case 6:
			System.out.println("You have to login first");
			logIn.getLogin();
			break;
		case 7:
			//7. Add Product item
			AdminAddProduct adminAddProduct=new AdminAddProduct();
			adminAddProduct.getAdminAddProduct();
			break;
		case 8:
			//8. Calculate Bill
			CalculateBill calculateBill= new CalculateBill();
			calculateBill.getCalculateBill();
			break;
		case 9:
			//9. Display amount to End User
			DisplayAmount displayAmount=new DisplayAmount();
			displayAmount.getDisplayAmount();
			break;
		case 10:
			CheckQuantity checkQuantity=new CheckQuantity();
			checkQuantity.getQuantity();
			break;
		case 11:
			CheckRegisteredUser checkRegisteredUser=new CheckRegisteredUser();
			checkRegisteredUser.getRegiseredUser();
			break;
		case 12:
			ParticularHistory particularHistory=new ParticularHistory();
			particularHistory.getParticularHistory();
			break;
		case 13:
			ViewProductGuest viewProductGuest=new ViewProductGuest();
			viewProductGuest.getProductListGuest();
			break;
		case 14:
			System.out.println("To buy any product you have to login first>> ");
			logIn.getLogin();
			break;
		}
	}
}
