package imcs.nishanth.EmployeeApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {

		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(EmployeeAppConfig.class); 
		EmployeeOperationsInterfaceImplementation employeeService = appContext.getBean(EmployeeOperationsInterfaceImplementation.class); 
		employeeService.findAll();
	}

}
