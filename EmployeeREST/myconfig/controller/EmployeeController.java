package controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import imcs.nishanth.EmployeeApplication.Employee;
import imcs.nishanth.EmployeeApplication.EmployeeOperationsInterface;

@Controller
public class EmployeeController {
    
	@Autowired
	EmployeeOperationsInterface employeeOperationsInterface;
	
	
	@RequestMapping(value="/updateEmployee",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute Employee employee){
		ModelAndView modelAndView = new ModelAndView();
	
		try {
			boolean flag=employeeOperationsInterface.updateEmployee(employee);
			if(flag==true){
			Map<String,Object> hm = new HashMap<String,Object>();
			hm.put("employee",employee);
			hm.put("message","EMPLOYEE GOT UPDATED SUCESSFULLY ");
			
			modelAndView.addAllObjects(hm);
			}
			else{
				modelAndView.addObject("message","ERROR...UNABLE TO UPDATE THE SPECIFIED EMPLOYEE");
			}
			
		} catch (Exception e) {
			modelAndView.addObject("message","Error..PLEASE TRY AGAIN ");
			e.printStackTrace();
		} 
		return modelAndView;
	}
	
	@RequestMapping(value="/createEmployee")
	public String createEmployee(Model model){
		model.addAttribute(new Employee());
		return "createEmployee";
	}
	
	@RequestMapping(value="/createEmployee",method=RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute @Valid Employee employee,BindingResult result){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(employee.getFirstName().length() + "is length of firstName");
			if(result.hasErrors()){
				modelAndView.setViewName("createEmployee");
				return modelAndView;
			}
		try {
			boolean flag=employeeOperationsInterface.createEmployee(employee);
			if (flag==true){
			modelAndView.addObject("message", "NEW EMPLOYEE ENTRY GOT CREATED SUCESSFULLY");
			}
			else{
				modelAndView.addObject("message", "ERROR IN CREATING THE EMPLOYEE");
			}
		} catch (Exception e) {
			modelAndView.addObject("message", "ERROR IN CREATING THE EMPLOYEE");
			e.printStackTrace();
		
		
		modelAndView.setViewName("home");
		
	}
		return modelAndView;
	}	
	
	@RequestMapping(value="/deleteEmployee")
	public String updateEmployee(Model model){
		
		model.addAttribute(new Employee());
		return "deleteEmployee";
	}
	@RequestMapping(value="/deleteEmployee",method=RequestMethod.POST)
	public ModelAndView deleteEmployee(@ModelAttribute Employee employee){
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			System.out.println(employee.getId());
			boolean flag=employeeOperationsInterface.deleteEmployee(employee.getId());
			if(flag==true){
				modelAndView.addObject("message", "SPECIFIED EMPLOYEE DETAILS GOT DELETED");
			}
			else{
				modelAndView.addObject("message", "UNABLE TO FIND THE REQUESTED EMPLOYEE DETAILS");
			}
		} catch (Exception e) {
			modelAndView.addObject("message", "THERE IS NO MATCH FOR THE SPECIFIED ID");
			e.printStackTrace();
		}
		
		modelAndView.setViewName("updateEmployee");
		return modelAndView;
	}
	
	
	
}
