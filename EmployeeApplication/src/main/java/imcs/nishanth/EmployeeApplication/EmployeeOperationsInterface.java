package imcs.nishanth.EmployeeApplication;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeOperationsInterface {

	void createEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	boolean deleteEmployee(int empId);
	

}
