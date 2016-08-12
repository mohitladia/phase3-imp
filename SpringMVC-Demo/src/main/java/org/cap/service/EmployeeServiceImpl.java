package org.cap.service;

import java.util.List;

import org.cap.dao.EmployeeDao;
import org.cap.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public void saveEmployee(Employee employee) {
		
		employeeDao.saveEmployee(employee);
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}

	@Transactional
	public void deleteEmployee(int employeeId) {
		
		employeeDao.deleteEmployee(employeeId);
	}

	@Transactional
	public Employee getEmployeeById(int id) {
		return this.employeeDao.getEmployeeById(id);
	
	}

	@Transactional
	public void updateEmployee(Employee e) {
		this.employeeDao.updateEmployee(e);
	
		
	}
}
