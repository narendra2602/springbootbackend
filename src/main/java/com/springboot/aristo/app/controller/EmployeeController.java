package com.springboot.aristo.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.aristo.app.dto.Attendance;
import com.springboot.aristo.app.dto.Employee;
import com.springboot.aristo.app.service.AttendanceService;
import com.springboot.aristo.app.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	private AttendanceService attendanceService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
		
	}
	
	
	@PostMapping()
	public ResponseEntity<Employee>  saveEmployee(@RequestBody Employee employee)
	{
		System.out.println(employee.toString());
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	
	@GetMapping()
	public List<Employee> getAllEmployee()
	{
		
		return employeeService.getAllEmployee(); 
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id)
	{
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
	}

	
	
	@DeleteMapping("{id}")
	public ResponseEntity <Map<String,Boolean>>  deleteEmployee( @PathVariable("id") long id)
	{
		System.out.println("yaha pr aaya delete mein "+id);
		employeeService.deleteEmployee(id);
		Map<String,Boolean> response = new HashMap<String,Boolean>();
		response.put("deleted", Boolean.TRUE);
		return  ResponseEntity.ok(response);
	}


	
	@PostMapping("/attendance")
	public List<Attendance>  getAttendanceEmployee(@RequestBody Employee employee)
	{
		System.out.println(employee.toString());
		
		return attendanceService.getAttendanceList(employee);
	}

}

