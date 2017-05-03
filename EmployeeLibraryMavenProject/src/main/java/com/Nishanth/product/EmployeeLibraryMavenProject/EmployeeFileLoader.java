package com.Nishanth.product.EmployeeLibraryMavenProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.Nishanth.product.EmployeeLibraryMavenProject.Employee.Gender;

public class EmployeeFileLoader {

	public EmployeeFileLoader(String[] words) {

	}


	public EmployeeFileLoader(){

		super();
	}
	public void fliesave(EmployeeOperations emp2){
	    
		  try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C://Users/nisha/workspace/Assignement/src/Assignment4c/Data"))){
			  ArrayList<Employee> createdEmployee = emp2.findAll();
			   for(Employee e:createdEmployee){
				   int gender=0;
				   if(e.getGender() == Gender.valueOf("MALE")){
					   gender=1;
				   }
				   else{
					   gender=2;
				   }
				   String line=e.getId() + ","+e.getFirstName()+","+e.getLastName()+","+e.getSalary()+","+gender;
				   bufferedWriter.write("\n"+line);
				   bufferedWriter.flush();
			   }
			   
			  
			  
		  }catch (Exception e2) {
		
			  e2.printStackTrace();
		}
		 
	  }
	public void filelaod(EmployeeOperations emp){	

		Employee employee;
		int id=0;
		String firstName=null;
		String lastName=null;
		double salary=0.0;
		int gender=0;
		String myLine = null;
		EmployeeFileLoader employeeFileLoader;
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C://Users/nisha/workspace/Assignement/src/Assignment4c/Data")))
			{

			while((myLine = bufferedReader.readLine()) != null){
				String[] mywords = myLine.split(",");
				id = Integer.parseInt(mywords[0]);
				
				firstName = mywords[1];
				lastName = mywords[2];
				salary = Double.parseDouble(mywords[3]);
				gender = Integer.parseInt(mywords[4]);
				emp.createEmployee(new Employee(id, firstName,lastName,salary,gender));
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
   
	}	
}
