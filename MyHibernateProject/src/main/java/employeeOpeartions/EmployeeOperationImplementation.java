package com.employeeOpeartions;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import com.employeeDAO.EmployeeDAOImplementation;

import pojo.Employee;

public class EmployeeOperationImplementation implements EmployeeOperationInterface{

	private EmployeeDAOImplementation daoImplementation;

	public boolean createEmployee(Employee employee) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		boolean flag = daoImplementation.save(employee);
		return true;
	}

	public Employee findEmployee(int id) {
		Employee employee = daoImplementation.get(id);
		return employee;		 
	}

	public List<Employee> findAll() {
		List<Employee> employees = daoImplementation.getAll();
		return employees;

	}

	public boolean deleteEmployee(int id) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		boolean flag = daoImplementation.delete(id);
		return true;
	}

	public boolean updateEmployee(Employee employee) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		boolean flag = daoImplementation.update(employee);
		return true;
	}

}
