package in.msingh.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.msingh.restapi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static List<Employee> list = new ArrayList<>();
	
	static {
		Employee e = new Employee();
		e.setName("Manish");
		e.setAge((long) 25);
		e.setLocation("India");
		e.setEmail("mk.2singh@gmail.com");
		e.setDepartment("IT");
		list.add(e);
		
	}
	
	

	@Override
	public List<Employee> getEmployees() {

		return list;
	}

}
