package com.springboot.aristo.app.service;

import java.util.List;

import com.springboot.aristo.app.dto.Attendance;
import com.springboot.aristo.app.dto.Employee;

public interface AttendanceService {

	List<Attendance> getAttendanceList(Employee emp);
}
