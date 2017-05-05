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
import employeeDatabase.Employee.Gender;
import employeeDatabase.EmployeeCreationException;
import employeeDatabase.EmployeeDaoImplementation;

public class EmployeeCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeCreation() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.html");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String firstname = request.getParameter("FirstName");
		String lastName = request.getParameter("lastName");
        String employeeId = request.getParameter("employeeID");
        String salary = request.getParameter("salary");
        String address = request.getParameter("address");
		String gender = request.getParameter("Gender");
        
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(employeeId));
		System.out.println(employeeId );
		
		employee.setFirstName(firstname);
		System.out.println(firstname );

		employee.setLastName(lastName);
		System.out.println(lastName );

        employee.setSalary(Double.parseDouble(salary));
		System.out.println(salary );

        employee.setAddress(address);
		System.out.println(address );

        employee.setGender(Gender.valueOf(gender.toUpperCase()));
		System.out.println(gender );



       EmployeeDaoImplementation dbImplementation = new EmployeeDaoImplementation();
      
       
		try {
			dbImplementation.save(employee);
            System.out.println("Employee data added sucessfully");				
		} catch(EmployeeCreationException e) {
			e.printStackTrace();
			System.out.println("Error...!");
		}
		
	}	
	

}
