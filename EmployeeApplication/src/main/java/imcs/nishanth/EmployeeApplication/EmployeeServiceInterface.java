package imcs.nishanth.EmployeeApplication;

import java.sql.SQLException;
import java.util.List;


public interface EmployeeServiceInterface {

	public boolean save(Employee employee);
	public List<Employee> getAll() throws SQLException;
	public boolean delete(int id) throws SQLException;
	public boolean update(Employee employee) throws SQLException;
	public Employee get(int id) throws SQLException;
	
	
}
