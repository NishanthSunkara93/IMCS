package com.employeeDAO;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import pojo.Employee;


public interface EmployeeDAO {

	public boolean save(Employee employee) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	public Employee get(int id);
	public boolean delete(int id) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	public boolean update(Employee employee) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;
	public List<Employee> getAll();
}
