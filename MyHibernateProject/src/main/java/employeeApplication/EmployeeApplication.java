package com.employeeApplication;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.employeeOpeartions.EmployeeOperationImplementation;

import pojo.Employee;
import util.EmployeeUtil;
import util.HibernateUtil;

public class EmployeeApplication {


	private EmployeeOperationImplementation employeeOperations;
	public EmployeeApplication(){
		employeeOperations=new EmployeeOperationImplementation();
	}
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, Exception {
		EmployeeApplication employeeApplication = new EmployeeApplication();

		System.out.println("************trng.Employee System**********");


		int choice = 0;
		@SuppressWarnings("unused")
		int operations=0;

		switch (choice) {
		case 1:

			try {
				employeeApplication.add();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			operations=1;

			break;
		case 2:
			operations=1;
			employeeApplication.display();
			break;
		case 3:
			operations=1;
			employeeApplication.displayAll();
			break;
		case 4:


			employeeApplication.update();

			break;
		case 5:

			employeeApplication.delete();

			break;
		default:
			System.out.println("Invalid Choice");
		}
	} 




private void delete() throws SQLException, Exception, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException{
	System.out.println("Enter the employee id to delete :");
	try{
		int empId = scanner.nextInt();

		boolean flag = employeeOperations.deleteEmployee(empId);
		if (flag) {
			System.out.println("Deleted successfully");
		} else {
			System.out.println("No employee found with given number : " + empId);
		}
	}
	catch(InputMismatchException e){
		System.out.println(e + " Please enter the valid id");
	}
}

private void update() throws  Exception {
	System.out.println("Enter Employees data for update:");
	Employee employee = EmployeeUtil.readEmployee();
	employeeOperations.updateEmployee(employee);
}

private void displayAll() throws SQLException {
	System.out.println("Employees in the system are :");
	List<Employee> employees = employeeOperations.findAll();
	for (Employee employee : employees) {
		System.out.println(employee);
	}
}

private void display() throws SQLException {
	System.out.println("Enter the employee id to view employee info :");
	try{
		int empId = scanner.nextInt();
		Employee employee = employeeOperations.findEmployee(empId);
		System.out.println(employee);
	}
	catch(InputMismatchException e){
		System.out.println(e + " Please enter valid data");
	}
}

private void add() throws Exception  {
	Employee employee = EmployeeUtil.readEmployee();
	boolean flag=employeeOperations.createEmployee(employee);
	if(flag==true){
		System.out.println("Employee created successfully");
	}
}

}











 




