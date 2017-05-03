package com.Nishanth.product.EmployeeLibraryMavenProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeUtil {

	private static Scanner scanner;

	public static int chooseOperation() throws InputMismatchException{

		int input = 0;
		System.out.println();
		System.out.println("   ||| MENU |||   ");
		System.out.println("1. Create Employee");
		System.out.println("2. Read(View) Employee");
		System.out.println("3. View all Employees");
		System.out.println("4. Update Employee");
		System.out.println("5. Delete Employee");
		System.out.println("6. Calculate HRA");
		System.out.println("7. Calculate Gross Salary");
		System.out.println("8. Exit");
		System.out.println("||====================================||");
		System.out.print("Select a choice:");
		scanner = new Scanner(System.in);

		input = scanner.nextInt();

		return input;        
	}

	public static Employee readEmployee() {
		scanner = new Scanner(System.in);
		System.out.print("Enter Employee id:");

		int id=0;
		double salary = 0.0;
		try {
			id = scanner.nextInt();
		} catch (InputMismatchException e1) {
			System.out.print("***Enter a valid ID*** \n ***The value of ID should be integer*** \n");
			readEmployee();
		}

		System.out.print("Enter Employee firstname:");
		String firstName = scanner.next();

		System.out.print("Enter Employee lastname:");
		String lastName = scanner.next();

		System.out.print("Enter Employee Salary(USD):");
		try{
			salary = scanner.nextDouble();
			if(salary>80000){
				System.out.println("Maximum salary limit for this employee is 10000$ \n Enter an acceptable salary");
				salary = scanner.nextDouble();

			}
		}catch(InputMismatchException e2){
			System.out.print("***Enter a valid salary*** \n ***The value of salary should be double*** \n");
			readEmployee();
		}
		System.out.println("Select the gender");
		System.out.println("	1.Male");
		System.out.println("	2.Female");
		int gender = scanner.nextInt();
		return new Employee(id, firstName, lastName, salary, gender);
	}
	public static int sortDataUtil(){
		// TODO Auto-generated method stub
		scanner =new Scanner(System.in);
		System.out.println("Please enter the sorting criteria");
		System.out.println("1.Name \n 2.Salary");
		try{
			int criteria=scanner.nextInt();
			return criteria;
		}
		catch(InputMismatchException e){
			System.out.println(e + "  Please enter the valid input 1 or 2");
		}

		return 0;
	}


}
