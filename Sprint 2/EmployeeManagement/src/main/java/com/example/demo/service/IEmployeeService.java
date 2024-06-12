package com.example.demo.service;

import java.util.List;
import com.example.demo.bean.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeWithId(int empId);

	Employee addEmployee(Employee emp);

	Employee updateEmployee(int empId, Employee emp);

	void deleteEmployee(int empId);

}