package com.assessment2.imcs.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;

import com.assessment2.imcs.business.PassengerOperationImp;
import com.assessment2.imcs.classes.Passenger;
import com.assessment2.imcs.util.PassengerUtil;

public class PassengerApp {
	private PassengerOperationImp imp;
	public PassengerApp(){
		imp=new PassengerOperationImp();
	}
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, Exception {
		PassengerApp app = new PassengerApp();

		System.out.println("************trng.Employee System**********");


		int choice = 0;
		@SuppressWarnings("unused")
		int operations=0;

		switch (choice) {
		case 1:

			try {
				app.add();
			} catch (Exception e) {
				e.printStackTrace();
			}
			operations=1;

			break;
		case 2:
			operations=1;
			app.display();
			break;

		case 4:


			app.update();

			break;
		case 5:

			app.delete();

			break;
		default:
			System.out.println("Invalid Choice");
		}
	} 




	private void delete() throws SQLException, Exception, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
		System.out.println("Enter the employee id to delete :");
		try{
			int profile_id = scanner.nextInt();

			boolean flag = imp.deletePassenger(profile_id);
			if (flag) {
				System.out.println("Deleted successfully");
			} else {
				System.out.println("No employee found with given number : " + profile_id);
			}
		}
		catch(InputMismatchException e){
			System.out.println(e + " Please enter the valid id");
		}
	}

	private void update() throws  Exception {
		System.out.println("Enter Employees data for update:");
		Passenger passanger = PassengerUtil.readPassanger();
		imp.updatepassenger(passanger);
	}



	private void display() throws SQLException {
		System.out.println("Enter the employee id to view employee info :");
		try{
			int empId = scanner.nextInt();
			Passenger passanger = imp.findPassenger(empId);
			System.out.println(passanger);
		}
		catch(InputMismatchException e){
			System.out.println(e + " Please enter valid data");
		}
	}

	private void add() throws Exception  {
		Passenger passanger = PassengerUtil.readPassanger();
		boolean flag=imp.createPassanger(passanger);
		if(flag==true){
			System.out.println("Employee created successfully");
		}

	}
}
