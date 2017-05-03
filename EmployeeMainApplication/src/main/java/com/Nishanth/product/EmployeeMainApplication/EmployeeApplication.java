package com.Nishanth.product.EmployeeMainApplication;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import com.Nishanth.product.EmployeeLibraryMavenProject.Employee;
import com.Nishanth.product.EmployeeLibraryMavenProject.EmployeeCollectionOperations;
import com.Nishanth.product.EmployeeLibraryMavenProject.EmployeeFileLoader;
import com.Nishanth.product.EmployeeLibraryMavenProject.EmployeeOperations;

import static com.Nishanth.product.EmployeeLibraryMavenProject.EmployeeUtil.chooseOperation;
import static com.Nishanth.product.EmployeeLibraryMavenProject.EmployeeUtil.readEmployee;

public class EmployeeApplication {

	private EmployeeOperations employeeOperations = null;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		EmployeeApplication employeeApplication = new EmployeeApplication();
		EmployeeFileLoader employeeFileLoader = new EmployeeFileLoader();
		employeeApplication.initme();
		employeeFileLoader.filelaod(employeeApplication.employeeOperations);

		System.out.println();
		System.out.println("************Employee System**********");

		int choice =0;
		do {
			try{
				choice = chooseOperation();
			}catch(InputMismatchException e){
				System.out.println("*****You have entered a wrong choice.Please enter right one*****");
				continue;
			}

			switch (choice) {
			case 1:
				employeeApplication.add();
				break;
			case 2:
				employeeApplication.display();
				break;
			case 3:
				employeeApplication.displayAll();
				break;
			case 4:
				employeeApplication.update();
				break;
			case 5:
				employeeApplication.delete();
				break;
			case 6:
				employeeApplication.displayHRA();
				break;
			case 7:
				employeeApplication.displayGrossSalary();
				break;
			case 8:
				employeeApplication.sortById();
				break;
			case 9:
				employeeApplication.sortByname();
				break;	
			case 10:
				employeeApplication.uniqueNames();
				break;
			case 11:
				employeeApplication.countEmployee();
				break;
			case 12:
				employeeFileLoader.fliesave(employeeApplication.employeeOperations);
				break;

			default:
				System.out.println("Invalid Choice");
			}
		} while (choice != 12);

		scanner.close();
	}

	private void countEmployee(){
		ArrayList<Employee> employees = employeeOperations.findAll();
        HashMap<Double, Integer> hashMap = ((EmployeeCollectionOperations)employeeOperations).salarywiseCount(employees);
	}
	
	private void uniqueNames(){
		ArrayList<Employee> employees = employeeOperations.findAll();
		HashSet<Employee> employeeSet = ((EmployeeCollectionOperations)employeeOperations).UniqueEmployeeSorting(employees);
		for (Employee emp: employeeSet){
			System.out.println(emp);
		}
		
	}

	private void sortById() {

		ArrayList<Employee> employees = employeeOperations.findAll();
		((EmployeeCollectionOperations)employeeOperations).EmployeeSorting(employees);
		for (Employee emp:employees){
			System.out.println(emp);
		}
	}
	private void sortByname() {

		ArrayList<Employee> employees = employeeOperations.findAll();
		((EmployeeCollectionOperations)employeeOperations).EmployeeSortingByNames(employees);
		for (Employee emp:employees){
			System.out.println(emp);
		}

	}

	private void displayGrossSalary() {
		System.out.println("Enter the employee id to calculte gross salary of employee");
		int empNo = scanner.nextInt();
		System.out.println("Gross Salary of employee id " + empNo + " is : " + ((EmployeeCollectionOperations)employeeOperations).calculateGrossSal(empNo));
	}

	private void displayHRA() {
		System.out.println("Enter the employee id to calculte hra of employee");
		int number = scanner.nextInt();
		System.out.println("Hra of employee id " + number + " is : " + employeeOperations.displayHRA(number));
	}

	private void delete() {
		System.out.println("Enter the employee id to delete :");
		int empId = scanner.nextInt();
		boolean flag = employeeOperations.deleteEmployee(empId);
		if (flag) {
			System.out.println("Deleted successfully");
		} else {
			System.out.println("No employee found with given number : " + empId);
		}
	}

	private void update() {
		System.out.println("Enter Employees data for update:");
		Employee employee = readEmployee();
		employeeOperations.updateEmployee(employee);
	}

	private void displayAll() {
		System.out.println("Employees in the system are :");
		ArrayList<Employee> employees = employeeOperations.findAll();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	private void display() {
		System.out.println("Enter the employee id to view employee info :");
		int empId = scanner.nextInt();
		Employee employee = employeeOperations.findEmployee(empId);
		System.out.println(employee);
	}

	private void add() {

		Employee employee = readEmployee();
		employeeOperations.createEmployee(employee);
		System.out.println(employee);
		System.out.println("Enter 8 to exit and save data \n Select specific operation to continue");

	}

	private void initme() {
		//System.out.print("How many Employees do you wish to create? ");
		employeeOperations = new EmployeeCollectionOperations();
	}


}
