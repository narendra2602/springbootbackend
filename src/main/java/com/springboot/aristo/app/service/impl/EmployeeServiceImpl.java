package com.springboot.aristo.app.service.impl;

import java.util.List;
 

import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dao.EmployeeDao;
import com.springboot.aristo.app.dto.Employee;
import com.springboot.aristo.app.exception.ResourceNotFoundException;
import com.springboot.aristo.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
		
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}



	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeDao.save(employee);
	}



	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		//return employeeDao.findAll();
		return employeeDao.getAllEmployees();
	}



	@Override
	public Employee getEmployeeById(long id) {

/*		Optional<Employee> employee = employeeDao.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		else
		{
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
*/
/*		return employeeDao.findById(id).orElseThrow(() -> 
		                              new ResourceNotFoundException("Employee", "id", id));
*/		
		Employee e = employeeDao.getEmployee(id);
		if(e!=null)
			return employeeDao.getEmployee(id);
		else
		{
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		

	}
	
	



	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// TODO Auto-generated method stub
		
		Employee emp = employeeDao.findById(id).orElseThrow(() -> 
        						new ResourceNotFoundException("Employee", "id", id));
		
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		employeeDao.save(emp);

		return emp;
	}



	@Override
	public void deleteEmployee(long id) {
		
		employeeDao.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Employee", "id", id));
		employeeDao.deleteById(id);
		
	}



	 

}
