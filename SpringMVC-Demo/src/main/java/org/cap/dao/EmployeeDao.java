package org.cap.dao;

import java.util.List;

import org.cap.pojo.Employee;

public interface EmployeeDao {

	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(int employeeId);
	public Employee getEmployeeById(int id);
	public void updateEmployee(Employee e);
}
