package imcs.nishanth.EmployeeApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImplementation implements EmployeeServiceInterface{

	int status;
	public boolean save(Employee employee) {
		String query = "Insert into Employee (id,firstName,lastName,salary,address,gender,flag) values (?,?,?,?,?,?,?)";
		try(Connection connection=ConnectionManager.getConnection();){
			PreparedStatement preparedStatement= connection.prepareStatement(query);
			connection.setAutoCommit(false);
			preparedStatement.setInt(1,employee.getId());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3,employee.getLastName());
			preparedStatement.setDouble(4, employee.getSalary());
			preparedStatement.setInt(7, 1);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}


	public List<Employee> getAll() throws SQLException {
      List<Employee> employeeList = new ArrayList<Employee>();
		try(Connection connection=ConnectionManager.getConnection();){
			PreparedStatement statement = connection.prepareStatement("select id, firstName, lastName,salary,address,gender from Employee where flag=?");
			statement.setInt(1,1);
			ResultSet resultSet = statement.executeQuery();

			//use resultset
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setFirstName(resultSet.getString("firstName"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setSalary(resultSet.getDouble("salary"));

				employeeList.add(employee);

			}
		}  
		return employeeList;
	}


	public boolean delete(int id) throws SQLException {

		try(Connection connection=ConnectionManager.getConnection();){
			Employee employee = get(id);
			if(employee == null){
			}
			PreparedStatement statement = connection.prepareStatement("update Employee set flag = ? where id = ?");
			try {
				statement.setInt(1, 0);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.setInt(2, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				status=statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if(status > 0){
			return true;
		}
		return false;	
	}


	public boolean update(Employee employee) throws SQLException {
		try(Connection connection=ConnectionManager.getConnection();){
			Employee employee1=get(employee.getId());
			if(employee1==null){
			}
			PreparedStatement preparedStatement=connection.prepareStatement("update Employee set firstName=?,lastName=?,salary=? where id=? ");

			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2,employee.getLastName());
			preparedStatement.setDouble(3, employee.getSalary());

			preparedStatement.setInt(6,employee.getId());
			status=preparedStatement.executeUpdate();
		}
		if(status>0){
			return true;
		}

		return false;

	}

	public Employee get(int id) throws SQLException {
		try(Connection connection=ConnectionManager.getConnection();){
			PreparedStatement statement = connection.prepareStatement("select id, firstName, lastName,salary from Employee where id = ? and flag= ? ");
			statement.setInt(1, id);
			statement.setInt(2, 1);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setFirstName(resultSet.getString("firstName"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setSalary(resultSet.getDouble("salary"));

				return employee;
			}
		}
		return null;
	}

}
