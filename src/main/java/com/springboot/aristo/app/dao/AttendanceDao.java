package com.springboot.aristo.app.dao;

import java.util.List;

 
import org.springframework.data.repository.CrudRepository;

import com.springboot.aristo.app.dto.Attendance;
import com.springboot.aristo.app.dto.Employee;
import org.springframework.data.domain.Sort;

public interface AttendanceDao extends CrudRepository<Attendance, Long> {

	 List<Attendance> findByEmp(Employee emp);
}
