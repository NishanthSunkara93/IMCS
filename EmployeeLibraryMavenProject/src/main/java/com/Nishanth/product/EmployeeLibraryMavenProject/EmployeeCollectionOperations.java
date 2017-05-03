package com.Nishanth.product.EmployeeLibraryMavenProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EmployeeCollectionOperations implements EmployeeOperations{

	private  ArrayList<Employee> employees;
	private int size;

	public EmployeeCollectionOperations() {
		employees = new ArrayList();
	}

	public void createEmployee(Employee employee) {
		employees.add(employee);

		/* if (size == employees.size()) {
            resizeEmployees();
        }*/  

		//employees.add(size++, employee); 
	}

	/* private void resizeEmployees() {
        employees = Arrays.copyOf(employees, size * 2);
    }
	 */
	public Employee findEmployee(int empId) {
		for (int i = 0; i < size; i++) {
			if (employees.get(i).getId() == empId) {
				return employees.get(i);
			}
		}
		return null;
	}

	public ArrayList<Employee>  findAll() {
		return employees;
		//return Arrays.copyOfRange(employees, 0, size);
	}

	public boolean deleteEmployee(int empId) {
		boolean flag = false;
		for (int i = 0; i < size; i++) {

			if (employees.get(i).getId() == empId) {
				employees.remove(i);                                   //delete by making it null
				/* for (int j = i; j < size-1; j++) {
                    employees[j] = employees[j + 1];                       // shift
                }*/
				flag = true;
				//employees[size--] = null;
			}
		}
		return flag;
	}

	public boolean updateEmployee(Employee employee) {
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			if (employees.get(i).getId() == employee.getId()) {
				employee = employees.get(i);
				flag = true;
				break;
			}
		}
		return flag;
	}


	public double displayHRA(int empId) {
		double hra = 0;
		for (int i = 0; i < size; i++) {
			if (employees.get(i).getId() == empId) {
				hra = employees.get(i).calculateHRA();
				break;
			}
		}

		return hra;
	}

	public Double calculateGrossSal(int empId) {
		for (int i = 0; i < size; i++) {
			if (employees.get(i).getId() == empId) {
				return employees.get(i).calculateGrossSal();
			}
		}
		return null;
	}

	public void EmployeeSorting(ArrayList<Employee> employees){

		Collections.sort(employees);
	}

	public void EmployeeSortingByNames(ArrayList<Employee> employees){
		Collections.sort(employees, new EmployeeNameComparator());
	}


    public HashSet<Employee> UniqueEmployeeSorting(ArrayList<Employee> employees){
		
		HashSet<Employee> employeeSet = new HashSet<>(employees);
		return employeeSet;
	}
    
    public HashMap<Double, Integer> salarywiseCount(ArrayList<Employee> employees){
		int count = 0;     
    	HashMap<Double, Integer> hashMap = new HashMap<>();
        for(Employee temp:employees){
        	if(hashMap.containsKey(temp.getSalary())){
        		  hashMap.put(temp.getSalary(), hashMap.get(temp.getSalary())+1);
        	}else{
        		hashMap.put(temp.getSalary(), 1);
        	}
        	
        }
    	
    	return null;
    	
    }

	
}
