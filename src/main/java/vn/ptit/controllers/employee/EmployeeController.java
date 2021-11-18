package vn.ptit.controllers.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.ptit.entities.employee.Employee;
import vn.ptit.services.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController {
	@Autowired EmployeeService employeeService;
	
	@GetMapping("/get/{username}")
	public Employee getByUsername(@PathVariable("username") String username) {
		return employeeService.loadEmployeeByUsername(username);
	}

}
