package com.takeo.service;

import java.util.List;

import com.takeo.binding.Employee;

public interface EmployeeService {
	public boolean saveEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(int id);

	public boolean updateEmployee(Employee emp);

	public void deleteEmployee(int id);

}
