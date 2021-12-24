package in.msingh.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//@RequestMapping("/api/v1")
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
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		
		return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber, pageSize),HttpStatus.OK);
	}
	
	@GetMapping(value="/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable() Long id) {
		
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping(value="/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		
		return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
		
	}
	
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
		
	}
	
	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeeByNameAndLocation(name, location), HttpStatus.OK);
		
	}
	
	@GetMapping("/employees/filterByKeyword")
	public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeeByKeyword(name), HttpStatus.OK);
		
	}
	
	
	@GetMapping(value="/employees/{name}/{location}")
	public ResponseEntity<List<Employee>> getEmployeesByNameORLocation(@PathVariable() String name, @PathVariable() String location) {
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameORLocation(name, location), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/employees/delete/{name}")
	public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
		
		return new ResponseEntity<String>(eService.deleteEmployeeByName(name) + " No. of records deleted ", HttpStatus.OK);
	}
	
	
	

}
