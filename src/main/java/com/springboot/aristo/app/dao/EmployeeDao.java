package com.springboot.aristo.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.aristo.app.dto.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Long> {
	
	@Query(value="CALL getAllEmployees();", nativeQuery=true)
	List<Employee> getAllEmployees();
	

	@Query(value="CALL getEmployee(:id_in);", nativeQuery=true)
	Employee getEmployee(@Param("id_in") Long id) ;

	/*@Procedure("getallemployees")
	List<Employee> getmployees();
	
	@Procedure(procedureName="getallemployees")
	List<Employee> getemployees();
	
	@Procedure(value="getallemployees")
	List<Employee> geteemployees();*/


}
