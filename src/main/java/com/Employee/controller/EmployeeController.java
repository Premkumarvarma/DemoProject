package com.Employee.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.model.Employee;
import com.Employee.service.EmployeeService;
import com.Employee.util.AppConstants;
import com.Employee.util.ServiceControllerUtils;
import com.Employee.util.ServiceResponse;


	@RestController
	@RequestMapping("/api/employee")
	public class EmployeeController {
		
		private static Logger logger = Logger.getLogger(EmployeeController.class);

		@Autowired
		private EmployeeService employeeService;

		@Autowired
		private ServiceControllerUtils scutils;

		@PostMapping("/saveemployee")
		public ResponseEntity<?> saveemployee(@RequestBody Employee employee) {
			logger.debug(">>accessed url is :/api/employee/saveemployee");
			ResponseEntity<?> resp = null;
			ServiceResponse restResponse = new ServiceResponse();
			try {
				employee = employeeService.saveEmployee(employee);
				if (employee != null) {
					restResponse.addDataObject("employee", employee);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse, "employee is saved");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
				} else {
					restResponse.addDataObject("employee", employee);
					restResponse = scutils.prepareMobileResponseInvalidData(restResponse, "employee is empty");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
				}
			} catch (Exception e) {
				restResponse = scutils.prepareMobileResponseErrorStatus(restResponse, AppConstants.ERRORCODE,e.getMessage());
				resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return resp;
		}

		@PutMapping("/updateemployee")
		public ResponseEntity<?> updateemployee(@RequestBody Employee employee) {
			logger.debug(">>accessed url is :/api/employee/updateemployee");
			ResponseEntity<?> resp = null;
			ServiceResponse restResponse = new ServiceResponse();
			try {
				employee = employeeService.updateEmployee(employee);
				if (employee != null) {
					restResponse.addDataObject("employee", employee);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse,"Successfully Updated employee");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
				} else {
					restResponse.addDataObject("employee", employee);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse, "Empty employee");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
					logger.debug(">>empty employee" + resp);
				}
			} catch (Exception e) {
				restResponse = scutils.prepareMobileResponseErrorStatus(restResponse, AppConstants.ERRORCODE,e.getMessage());
				resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
				logger.debug(">>Exceptions are: " + resp);
			}
			return resp;
		}

		@GetMapping("/findAllemployee")
		public ResponseEntity<?> findAllemployee() {
			logger.debug(">>accessed url is :/api/employee/findAllemployee");
			ResponseEntity<?> resp = null;
			ServiceResponse restResponse = new ServiceResponse();
			try {
				List<Employee> employeeList = employeeService.findAllEmployees();
				if (employeeList != null && !employeeList.isEmpty()) {
					restResponse.addDataObject("employeeList", employeeList);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse,"Successfully Fetched employees");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
				} else {
					restResponse.addDataObject("employeeList", employeeList);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse, "empty employeeList");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
					logger.debug(">>empty employeeList" + resp);
				}
			} catch (Exception e) {
				restResponse = scutils.prepareMobileResponseErrorStatus(restResponse, AppConstants.ERRORCODE,e.getMessage());
				resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
				logger.debug(">>Exceptions are: " + resp);
			}
			return resp;
		}

		@DeleteMapping("/deleteemployeeById")
		public ResponseEntity<?> deleteemployeeById(@RequestParam(value = "_id", required = true) String _id) {
			logger.debug(">>accessed url is :/api/employee/deleteemployeeById");
			ResponseEntity<?> resp = null;
			ServiceResponse restResponse = new ServiceResponse();
			Employee employee = null;
			try {
				employee = employeeService.deleteEmployeeById(_id);
				if (employee != null) {
					restResponse.addDataObject("employee", employee);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse,"Successfully Deleted employee");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
				} else {
					restResponse.addDataObject("employee", employee);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse, "Empty employee");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
					logger.debug(">>empty employee" + resp);
				}
			} catch (Exception e) {
				restResponse = scutils.prepareMobileResponseErrorStatus(restResponse, AppConstants.ERRORCODE,e.getMessage());
				resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
				logger.debug(">>Exceptions are: " + resp);
				e.printStackTrace();
			}
			return resp;
		}

		@GetMapping("/findemployeeById")
		public ResponseEntity<?> findemployeeById(@RequestParam(value = "_id", required = true) String _id) {
			logger.debug(">>accessed url is :/api/employee/findemployeeById");
			ResponseEntity<?> resp = null;
			ServiceResponse restResponse = new ServiceResponse();
			Employee employee = null;
			try {
				employee = employeeService.deleteEmployeeById(_id);
				if (employee != null) {
					restResponse.addDataObject("employee", employee);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse,"Successfully Fetched employee");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
				} else {
					restResponse.addDataObject("employee", employee);
					restResponse = scutils.prepareMobileResponseSuccessStatus(restResponse, "Empty employee");
					resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.OK);
					logger.debug(">>empty employee" + resp);
				}
			} catch (Exception e) {
				restResponse = scutils.prepareMobileResponseErrorStatus(restResponse, AppConstants.ERRORCODE,e.getMessage());
				resp = new ResponseEntity<ServiceResponse>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
				logger.debug(">>Exceptions are: " + resp);
				e.printStackTrace();
			}
			return resp;
		}
		
}
