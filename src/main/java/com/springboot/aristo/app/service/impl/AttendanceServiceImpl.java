package com.springboot.aristo.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dao.AttendanceDao;
import com.springboot.aristo.app.dto.Attendance;
import com.springboot.aristo.app.dto.Employee;
import com.springboot.aristo.app.service.AttendanceService;


@Service
public class AttendanceServiceImpl implements AttendanceService{

	
	@Autowired
	private AttendanceDao attendanceDao;
	
	@Override
	public List<Attendance> getAttendanceList(Employee emp) {
		
		return attendanceDao.findByEmp(emp);
	}

}
