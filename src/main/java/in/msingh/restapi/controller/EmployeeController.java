package in.msingh.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.msingh.restapi.model.Employee;
import in.msingh.restapi.service.EmployeeService;

//@Controller
@RestController  // It is a combination of @Controller + @ResponseBody
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetails() {
		return appName + " - " + appVersion;
	}
	
	@GetMapping(value="/")
	public String getHomePage() {
		return "Displaying Home Page";
	}
	
	@GetMapping(value="/employees")
	//@ResponseBody
	public List<Employee> getEmployees() {
		
		return eService.getEmployees();
	}
	
	@GetMapping(value="/employees/{id}")
	public String getEmployee(@PathVariable() Long id) {
		
		return "Single Employee with id " + id ;
	}
	
	@DeleteMapping(value="/employees")
	public String deleteEmployee(@RequestParam("id") Long id) {
		
		return "Employee Deleted with emp id " + id;
		
	}
	
	@PostMapping(value="/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		
		return "Saving Employee "+ employee;
		
	}
	
	@PutMapping(value="/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		
		System.out.println("Updating the Employee with emp id "+ id);
		return employee;
		
	}
	
	//1:02:04

}
