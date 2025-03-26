package com.Employee.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.Employee.dao.EmployeeDao;
import com.Employee.model.Employee;
import com.Employee.util.RequestConstants;

import Exception.AppDaoException;

@Service
public class EmployeeDaoImpl implements EmployeeDao{

	private static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private MongoOperations mongoOperations;


	public Employee saveEmployee(Employee employee) throws AppDaoException {
		logger.debug(">>>>> Start of saveEmployee save method................Employee" + employee);
		try {
			employee = this.mongoOperations.save(employee, RequestConstants.Collections.COLLECTION_EMPLOYEE);
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of saveEmployee method..........employee" + employee);
		return employee;
	}


	public Employee updateEmployee(Employee employee) throws AppDaoException {
		logger.debug(">>>>> Start of updateEmployee save method................Employee" + employee);
		try {
			employee = this.mongoOperations.save(employee, RequestConstants.Collections.COLLECTION_EMPLOYEE);
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of updateEmployee method..........employee" + employee);
		return employee;
	}


	public Employee deleteEmployeeById(String _id) throws AppDaoException {
		logger.debug(">>>>> Start of deleteEmployeeById save method................Employee" + _id);
		Employee employeeObj = null; 
		Query searchQuery = null;
		try {
			if(_id !=  null) {
				searchQuery = new Query(Criteria.where("_id").is(_id));
				employeeObj = this.mongoOperations.findAndRemove(searchQuery, Employee.class,RequestConstants.Collections.COLLECTION_EMPLOYEE);
			}
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of updateEmployee method..........employee" + _id);
		return employeeObj;
	}


	public Employee findEmployeeById(String _id) throws AppDaoException {
		logger.debug(">>>>> Start of findEmployeeById save method................Employee" + _id);
		Employee employeeObj = null; 
		Query searchQuery = null;
		try {
			if(_id !=  null) {
				searchQuery = new Query(Criteria.where("_id").is(_id));
				employeeObj = this.mongoOperations.findOne(searchQuery, Employee.class,RequestConstants.Collections.COLLECTION_EMPLOYEE);
			}
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of findEmployeeById method..........employee" + _id);
		return employeeObj;
	}


	public List<Employee> findAllEmployees() throws AppDaoException {
		logger.debug(">>>>> Start of findEmployeeById save method................employeeList");
		List<Employee> employeeList = null; 
		Query searchQuery = null;
		try {
			employeeList = this.mongoOperations.find(searchQuery, Employee.class,RequestConstants.Collections.COLLECTION_EMPLOYEE);
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of findEmployeeById method..........employeeList" + employeeList);
		return employeeList;
	}

}
