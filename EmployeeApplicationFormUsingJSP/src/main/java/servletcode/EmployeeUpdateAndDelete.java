package servletcode;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Nishanth.product.EmployeeLibraryMavenProject.EmployeeCreationException;
import com.Nishanth.product.EmployeeLibraryMavenProject.InvalidSalaryException;

import employeeDatabase.Employee;
import employeeDatabase.EmployeeDaoImplementation;
import employeeDatabase.InvalidEmployeeException;


public class EmployeeUpdateAndDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int temporaryID;  
	String action;

	public EmployeeUpdateAndDelete() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("UpdateAndDelete.jsp");
		requestDispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		EmployeeDaoImplementation dbRetrivalImplementation = new EmployeeDaoImplementation();
		Employee employee;
		action = request.getParameter("action");
		if(action.equals("search")){


			try {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				employee = dbRetrivalImplementation.get(employeeId);
				if(employee==null){
					request.setAttribute("notFound",true);
					request.getRequestDispatcher("/UpdateAndDelete.jsp").forward(request,response);
				}
				else{


					request.setAttribute("employee",employee);
					request.getRequestDispatcher("/UpdateAndDelete.jsp").forward(request,response);

				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				request.setAttribute("notFound",true);
				request.getRequestDispatcher("/UpdateAndDelete.jsp").forward(request,response);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
				request.setAttribute("notFound",true);
				request.getRequestDispatcher("/UpdateAndDelete.jsp").forward(request,response);
			}

		}

		if(action.equalsIgnoreCase("delete")){
			temporaryID = Integer.parseInt(request.getParameter("employeeID"));
			try {
				boolean flag=dbRetrivalImplementation.delete(temporaryID);
				System.out.println("Employee Data got deleted");
				request.setAttribute("deleted", true);
				request.getRequestDispatcher("/UpdateAndDelete.jsp").forward(request,response);
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("An error in performing the operation");
			} catch (InvalidEmployeeException e) {
				e.printStackTrace();
				System.out.println("Cannot find the specified employee ID");
			}
			
		}else if (action.equalsIgnoreCase("update")) {
			int empId = Integer.parseInt(request.getParameter("employeeId"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			System.out.println(request.getParameter("salary"));
			double salary = Double.parseDouble(request.getParameter("salary"));
			String address=request.getParameter("address");
			String gender = null;
			try {
				gender = dbRetrivalImplementation.get(empId).getGender().toString().toLowerCase();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int gender1=0;
			if(gender.equals("male")){
				gender1 = 1;
			}else{
				gender1 = 2;
			}
			employee = new Employee(empId,firstName,lastName,salary,address,gender1);


			try {
				boolean flag = dbRetrivalImplementation.update(employee);
				if(flag == true){
					request.setAttribute("updated", true);
					request.setAttribute("employee", employee);
					request.getRequestDispatcher("/UpdateAndDelete.jsp").forward(request,response);
				}
				else{
					request.setAttribute("updated", false);
					request.getRequestDispatcher("/UpdateEmployee.jsp").forward(request,response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("updated", false);
				request.getRequestDispatcher("/UpdateAndDelete.jsp").forward(request,response);
			} catch (InvalidEmployeeException e) {
				e.printStackTrace();
				request.setAttribute("updated", false);
				request.getRequestDispatcher("/UpdateAndDelete.jsp").forward(request,response);
			}

		}
		else if (action.equalsIgnoreCase("viewall")) {
			try {
				List<Employee> employeeRetrivedData = dbRetrivalImplementation.getAll();
				if(employeeRetrivedData != null){
					request.setAttribute("displayResults",employeeRetrivedData );
					request.getRequestDispatcher("UpdateAndDelete.jsp").forward(request, response);
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("Error.html"); 
					dispatcher.forward(request, response);
				}
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error in dispalying employee information");
			}
		}
		

	}

}
