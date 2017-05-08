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
	    request.getParameter("employeeID");
        int temp = Integer.parseInt(request.getParameter("employeeID"));
		EmployeeDaoImplementation dbRetrivalImplementation = new EmployeeDaoImplementation();
		

		try {
			
			Employee retrivedData = dbRetrivalImplementation.get(temp);
			System.out.println(temp);
			if(retrivedData != null)
			{
				printWriter.print("<table width=50% border=1>");  
				printWriter.print("<caption>Employee Details:</caption>");  
				printWriter.println("<tr><td>id</td><td>"+retrivedData.getId()+"</td></tr>");
				printWriter.println("<tr><td>id</td><td>"+retrivedData.getFirstName()+"</td></tr>");
				printWriter.println("<tr><td>id</td><td>"+retrivedData.getLastName()+"</td></tr>");
				printWriter.println("<tr><td>id</td><td>"+retrivedData.getSalary()+"</td></tr>");
				printWriter.println("<tr><td>id</td><td>"+retrivedData.getGender()+"</td></tr>");
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("Error.html"); 
				dispatcher.forward(request, response);
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}


	}

}
