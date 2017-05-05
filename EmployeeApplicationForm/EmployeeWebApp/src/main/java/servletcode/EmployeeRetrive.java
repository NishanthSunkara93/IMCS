package servletcode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeeDatabase.Employee;
import employeeDatabase.EmployeeDaoImplementation;


public class EmployeeRetrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeRetrive() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("receive.html");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String employeeId = request.getParameter("employeeID");

		Employee employee = new Employee();
		EmployeeDaoImplementation dbRetrivalImplementation = new EmployeeDaoImplementation();
		

		try {

			Employee retrivedData = dbRetrivalImplementation.get(Integer.parseInt(employeeId));
             System.out.println(retrivedData);
			if(employee != null)
			{
				printWriter.print("<table width=50% border=1>");  
				printWriter.print("<caption>Employee Details:</caption>");  
				printWriter.println("<tr><td>id</td><td>"+employee.getId()+"</td></tr>");
				printWriter.println("<tr><td>id</td><td>"+employee.getFirstName()+"</td></tr>");
				printWriter.println("<tr><td>id</td><td>"+employee.getLastName()+"</td></tr>");
				printWriter.println("<tr><td>id</td><td>"+employee.getSalary()+"</td></tr>");
				printWriter.println("<tr><td>id</td><td>"+employee.getGender()+"</td></tr>");
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.html"); 
				dispatcher.forward(request, response);
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

}
