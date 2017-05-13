package imcs.nishanth.EmployeeApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeOperationsInterfaceImplementation  implements EmployeeOperationsInterface{

	private  ArrayList<Employee> employees;
	private int size;
	int status;
   
	public void EmployeeCollectionOperations() {
		employees = new ArrayList();
	}

	public void createEmployee(Employee employee) {
		employees.add(employee);

	}

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
	}

	public boolean deleteEmployee(int empId) {
		boolean flag = false;
		for (int i = 0; i < size; i++) {

			if (employees.get(i).getId() == empId) {
				employees.remove(i);                                  
				flag = true;
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

}
