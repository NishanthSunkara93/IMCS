package com.employeeOpeartions;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import pojo.Employee;

public interface EmployeeOperationInterface {

	boolean createEmployee(Employee employee) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;

    Employee findEmployee(int id);

    List<Employee> findAll();
    
    boolean deleteEmployee(int empId) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;

    boolean updateEmployee(Employee employee) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException;

}
