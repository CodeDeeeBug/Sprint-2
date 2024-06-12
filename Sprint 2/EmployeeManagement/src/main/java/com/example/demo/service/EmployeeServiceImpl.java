package com.example.demo.service;

import java.util.*;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	EmployeeDao dao = new EmployeeDao();
	

	@Override
	public List<Employee> getAllEmployees()
	{
		return dao.findAllEmployees();
	}
	
	@Override
	public Employee getEmployeeWithId(int empId)
	{
		return dao.getById(empId);
	}
	
	@Override
	public Employee addEmployee(Employee emp)
	{
		return (Employee)dao.addEmployee(emp);
	}
	
	@Override
	public Employee updateEmployee(int empId,Employee emp)
	{
		return dao.updateEmployee(emp);
	}
	
	@Override
	public void deleteEmployee(int empId)
	{
		dao.deleteById(empId);
	}
}
