package imcs.nishanth.EmployeeApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
  
private static Connection connection;
	
	private ConnectionManager()
	{
		
	}
	
	
	public static Connection getConnection(){
	
		
		final String driver="com.mysql.jdbc.Driver";
		
		final String url="jdbc:mysql://localhost:3306/employeeinfo";
		
		final String user="Student";
		
		final String password="Student";

		
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) 
		{
			System.out.println("Connection terminated");
		} catch (ClassNotFoundException e)
		{
			System.out.println("Unable to find the class");
		}
		return connection;
	}
	
		public static void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("fail to close the Connection");
		}
	}
}
