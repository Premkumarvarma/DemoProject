package com.Employee.service;

import java.util.List;
import java.util.Map;

import com.Employee.model.Employee;

import Exception.AppServiceException;

public interface EmployeeService {
	
	
	Employee saveEmployee (Employee employee) throws AppServiceException;
	
	Employee updateEmployee (Employee employee) throws AppServiceException;
	
	Employee deleteEmployeeById (String _id) throws AppServiceException;
	
	Employee findEmployeeById (String _id) throws AppServiceException;

	List<Employee> findAllEmployees() throws AppServiceException;
	
	Map<String, List<String>> excelUploadBPXMethodologyData(List<Employee> employeeList) throws AppServiceException;
	

}
