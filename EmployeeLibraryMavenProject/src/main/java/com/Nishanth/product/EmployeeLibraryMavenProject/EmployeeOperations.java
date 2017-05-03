package com.Nishanth.product.EmployeeLibraryMavenProject;

import java.util.ArrayList;

public interface EmployeeOperations {

    void createEmployee(Employee employee);

    Employee findEmployee(int empId);

    ArrayList<Employee> findAll();

    boolean deleteEmployee(int empId);

    boolean updateEmployee(Employee employee);

    double displayHRA(int empId);

    Double calculateGrossSal(int empId);
    
    
}
