package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired()
	IEmployeeService service;
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return service.getAllEmployees();
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeWithId(@PathVariable int empId)
	{
		return service.getEmployeeWithId(empId);
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{	 
		 return new ResponseEntity(service.addEmployee(emp),HttpStatus.CREATED);
	   
		
		
	}

	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId,@RequestBody Employee emp) {
		return new ResponseEntity(service.updateEmployee(empId, emp),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/employee/{empId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable int empId)
	{
		service.deleteEmployee(empId);
	}

}
