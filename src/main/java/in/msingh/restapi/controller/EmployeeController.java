package in.msingh.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController  // It is a combination of @Controller + @ResponseBody
public class EmployeeController {
	
	
	@GetMapping(value="/employees")
	//@ResponseBody
	public String getEmployees() {
		
		return "Displaying the List fo Employees";
	}

}
