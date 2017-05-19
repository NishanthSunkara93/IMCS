package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import pojo.Employee;
import pojo.Address;
public class EmployeeUtil {

	private static Scanner scanner ;//= new Scanner(System.in);

	public static int chooseOperation() throws InputMismatchException {
		scanner  = new Scanner(System.in);
		System.out.println();
		System.out.println("   ||| MENU |||   ");
		System.out.println("1. Create trng.Employee");
		System.out.println("2. Read(View) trng.Employee");
		System.out.println("3. View all Employees");
		System.out.println("4. Update Employee");
		System.out.println("5. Delete Employee");
		System.out.println("6. Calculate HRA");
		System.out.println("7. Calculate Gross Salary");
		System.out.println("8. Sort Employees");
		System.out.println("9. View unique Employees");
		System.out.println("10. View salary count");
		System.out.println("11. Exit");


		System.out.print("Select a choice :");

		int id=scanner.nextInt();
		return id;
	}

	public static Employee readEmployee() throws Exception{
		scanner = new Scanner(System.in);
		boolean flag=true;
		while(flag==true){

			try{
				System.out.print("Enter trng.Employee id:");
				int id = scanner.nextInt();

				System.out.print("Enter trng.Employee firstname:");
				String firstName = scanner.next();

				System.out.print("Enter trng.Employee lastname:");
				String lastName = scanner.next();

				System.out.print("Enter trng.Employee Salary: between (1 and 100000)");
				double salary = scanner.nextDouble();
				
				System.out.print("Enter trng.Employee Address: ");
				String address = scanner.next();

				System.out.println("Select the gender");
				System.out.println("	1.Male");
				System.out.println("	2.Female");

				int gender = scanner.nextInt();
				if(gender >2 || gender <1){
					throw new Exception("Please enter the valid data");
				}

			return new Employee(id, firstName, lastName, salary, address, gender);
			}
			catch(InputMismatchException e){
				throw new Exception("Please enter valid data ");
			}

		}
		return null;
	}

}
