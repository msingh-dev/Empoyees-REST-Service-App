package in.msingh.restapi.service;

import java.util.List;

import in.msingh.restapi.model.Employee;


public interface EmployeeService {

	 List<Employee> getEmployees(int pageNumber, int pageSize);
	 
	 Employee saveEmployee(Employee employee);
	 
	 Employee getSingleEmployee(Long id);
	 
	 void deleteEmployee(Long id);
	 
	 Employee updateEmployee(Employee employee);
	 
	 List<Employee> getEmployeesByName(String name);
	 
	 List<Employee> getEmployeeByNameAndLocation(String name, String location);
	 
	 List<Employee> getEmployeeByKeyword(String keyword);
	 
	 List<Employee> getEmployeesByNameORLocation(String name, String location);
	 
	 Integer deleteEmployeeByName(String name);
	 
	 

}