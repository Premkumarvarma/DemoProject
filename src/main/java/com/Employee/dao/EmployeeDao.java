package com.Employee.dao;

import java.util.List;

import com.Employee.model.Employee;

import Exception.AppDaoException;

public interface EmployeeDao {

	Employee saveEmployee (Employee employee) throws AppDaoException;

	Employee updateEmployee (Employee employee) throws AppDaoException;

	Employee deleteEmployeeById (String _id) throws AppDaoException;

	Employee findEmployeeById (String _id) throws AppDaoException;

	List<Employee> findAllEmployees() throws AppDaoException;
	
}
