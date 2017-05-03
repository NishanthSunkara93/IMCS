package com.Nishanth.product.EmployeeLibraryMavenProject;

import java.util.Comparator;

public class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
        
		final int BEFORE =-1;
		final int AFTER = 1;
		final int EQUAL = 0;
		
		if (e1.getFirstName().compareTo(e2.getFirstName()) > 0) return AFTER;
		if (e1.getFirstName().compareTo(e2.getFirstName()) < 0) return BEFORE;
	
		return EQUAL;
	}
 
	
	   
	
}
