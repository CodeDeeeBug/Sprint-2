package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.Employee;

public class EmployeeDao 
{
	static List<Employee> list = null;

	static 
	{
		list = new ArrayList<>();
		list.add(new Employee(101,"Ram",25000.0f));
		list.add(new Employee(102,"Mahesh",35000.0f));
		list.add(new Employee(103,"Ganesh",30000.0f));
		list.add(new Employee(104,"Tejal",27000.0f));
		list.add(new Employee(105,"Manisha",22000.0f));
		list.add(new Employee(106,"Rony",28000.0f));
		list.add(new Employee(107,"Sachin",21000.0f));
	}
	
	public List<Employee> findAllEmployees() 
	{
		return list;
	}

	public List<Employee> addEmployee(Employee employee) {
		list.add(employee);
		return list;
	}

	public Employee getById(int id) {

		Employee vehicle = null;

		for (Employee employee : list) {
			if (employee.getEmpId() == id) {
				vehicle = employee;
				break;
			}
		}
		return vehicle;
	}

	public List<Employee> deleteById(int id) {

		for (Employee employee : list) {
			if (employee.getEmpId() == id) {
				list.remove(employee);
				break;
			}
		}
		return findAllEmployees();
	}

	public Employee updateEmployee(Employee employee) {

		int index = 0;
		Employee employeeData = null;
		for (Employee e : list) {
			if (e.getEmpId() == employee.getEmpId()) {
				index = list.indexOf(e);
				e.setEmpName(employee.getEmpName());
				e.setEmpSal(employee.getEmpSal());
				list.set(index, e);
				employeeData = e;
				break;
			}
		}
		return employeeData;
	}


}
