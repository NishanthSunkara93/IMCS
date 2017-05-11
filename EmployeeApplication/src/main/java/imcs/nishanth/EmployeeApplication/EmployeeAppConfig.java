package imcs.nishanth.EmployeeApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"imcs.nishanth.EmployeeApplication.*"})
public class EmployeeAppConfig 
{


	@Bean
	public EmployeeOperationsInterface getCollectionObject(){
		return new EmployeeOperationsInterfaceImplementation();
	}

	@Bean
	public Employee getEmployee(){
		return new Employee();
	}

	@Bean
	public EmployeeServiceImplementation EmployeeRepositoryImplementation(){
		return new EmployeeServiceImplementation();
	}


}


