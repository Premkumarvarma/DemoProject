package com.Employee.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.dao.EmployeeDao;
import com.Employee.model.Employee;
import com.Employee.service.EmployeeService;

import Exception.AppServiceException;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDao employeedao;

	@Override
	public Employee saveEmployee(Employee employee) throws AppServiceException {
		logger.debug(">>>>> Start of saveEmployee save method................Employee" + employee);
		try {
			employee = employeedao.saveEmployee(employee);
		}catch (Exception e) {	
			throw new AppServiceException("", "",e);
		}
		logger.debug(">>>>> End of saveEmployee save method................Employee" + employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws AppServiceException {
		logger.debug(">>>>> Start of updateEmployee save method................Employee" + employee);
		try {
			employee = employeedao.updateEmployee(employee);
		}catch (Exception e) {
			throw new AppServiceException("", "",e);
		}
		logger.debug(">>>>> End of updateEmployee save method................Employee" + employee);
		return employee;
	}

	@Override
	public Employee deleteEmployeeById(String _id) throws AppServiceException {
		logger.debug(">>>>> Start of deleteEmployeeById  method................_id" + _id);
		Employee employee = null;
		try {
			employee = employeedao.deleteEmployeeById(_id);
		}catch (Exception e) {
			throw new AppServiceException("", "",e);
		}
		logger.debug(">>>>> End of deleteEmployeeById  method................employee" + employee);
		return employee;
	}

	@Override
	public Employee findEmployeeById(String _id) throws AppServiceException {
		logger.debug(">>>>> Start of findEmployeeById  method................_id" + _id);
		Employee employee = null;
		try {
			employee = employeedao.deleteEmployeeById(_id);
		}catch (Exception e) {
			throw new AppServiceException("", "",e);
		}
		logger.debug(">>>>> End of findEmployeeById  method................employee" + employee);
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees() throws AppServiceException {
		logger.debug(">>>>> Start of findAllEmployee  method................" );
		List<Employee> employeeList = null;
		try {
			employeeList = employeedao.findAllEmployees();
		}catch (Exception e) {
			throw new AppServiceException("","",e);
			// TODO: handle exception
		}
		logger.debug(">>>>> End of findAllEmployee  method................Employee" );
		return employeeList;
	}

	public Map<String, List<String>> excelUploadBPXMethodologyData(List<Employee> employeeList) throws AppServiceException {
		logger.info("start of Employee excelUploadEmployeeData method");

		List<String> EmployeeSuccessExcelList = new ArrayList<String>();  
		List<String> EmployeeFailureExcelList = new ArrayList<String>(); 
		List<String> EmployeeDuplicateExcelList = new ArrayList<String>();
		Map<String, List<String>> excelSuccessAndFailureMap = new HashMap<String,List<String>>(); 
		int index = 0; 
		Employee employeeDbObj = null;
		try {

		}catch (Exception e) {
			throw new AppServiceException("","",e);
		}

		return excelSuccessAndFailureMap;
	}


	/*
	 * public Map<String, List<String>> excelUploadBPXMethodologyData(List<Employee>
	 * employeeList) throws AppServiceException {
	 * 
	 * logger.info("start of Employee excelUploadEmployeeData method");
	 * 
	 * List<String> EmployeeSuccessExcelList = new ArrayList<String>(); 
	 * List<String>
	 * EmployeeFailureExcelList = new ArrayList<String>(); List<String>
	 * EmployeeDuplicateExcelList = new ArrayList<String>(); Map<String,
	 * List<String>> excelSuccessAndFailureMap = new HashMap<String,
	 * List<String>>(); int index = 0; Employee employeeDbObj = null; try {
	 * 
	 * if (employeeList != null) { List<OrganizationUnit> organizationUnits =
	 * this.findAll(OrganizationUnit.class,
	 * RequestConstants.Collections.COLLECTION_ORGANIZATION_UNIT); List<String>
	 * organizationUnitCodeList = new ArrayList<String>(); List<String>
	 * organizationUnitNameList = new ArrayList<String>(); if (organizationUnits !=
	 * null && organizationUnits.size() > 0) { for (OrganizationUnit
	 * organizationUnit : organizationUnits) {
	 * organizationUnitNameList.add(organizationUnit.getName());
	 * organizationUnitCodeList.add(organizationUnit.getCode()); } }
	 * 
	 * List<Employee> EmployeeDbList = this.findAllEmployees(); HashMap<String,
	 * Employee> EmployeeCodeMap = new HashMap<>(); HashMap<String, Employee>
	 * EmployeeNameMap = new HashMap<>(); if (EmployeeDbList != null &&
	 * EmployeeDbList.size() > 0) { for (Employee Employee : EmployeeDbList) {
	 * EmployeeCodeMap.put(Employee.getMethodologyCode(), Employee);
	 * EmployeeNameMap.put(Employee.getMethodologyName(), Employee); } } for
	 * (Employee employee : employeeList) { if (employee != null) { index = index +
	 * 1;
	 * 
	 * List<String> EmployeeManditoryList =
	 * DataUploadUtils.ExcelMessages.BPX_METHODOLOGY_MANDITORY_FIELDS;
	 * HashMap<String, Object> EmployeePropertiesMap =
	 * this.getBeanPropertiesOfEmployee(Employee); boolean manditoryFieldMissing =
	 * false; if (EmployeeManditoryList != null && EmployeeManditoryList.size() > 0)
	 * { for (String EmployeeManditoryField : EmployeeManditoryList) { Object object
	 * = EmployeePropertiesMap.getOrDefault(EmployeeManditoryField,null); if (object
	 * == null || object == "") { String manditoryFieldsMsg =
	 * this.getManditoryFieldsByConcatination(EmployeeManditoryList);
	 * EmployeeFailureExcelList.add("Employee " +
	 * DataUploadUtils.ExcelMessages.AT_LINE_MSG + index +
	 * DataUploadUtils.ExcelMessages.MANDITORY_MSG + manditoryFieldsMsg);
	 * manditoryFieldMissing = true; break; } } } if (manditoryFieldMissing) {
	 * continue; }
	 * 
	 * if (Employee.getOrgCode() != null&& Employee.getOrgCode() != "") { if
	 * (!organizationUnitCodeList.contains(Employee.getOrgCode())) {
	 * EmployeeFailureExcelList.add("Employee " +
	 * DataUploadUtils.ExcelMessages.AT_LINE_MSG + index + " - orgCode: " +
	 * Employee.getOrgCode() + " is not configured in meta datas"); continue; } } if
	 * (Employee.getOrgName() != null&& Employee.getOrgName() != "") { if
	 * (!organizationUnitNameList.contains(Employee.getOrgName())) {
	 * EmployeeFailureExcelList.add("Employee " +
	 * DataUploadUtils.ExcelMessages.AT_LINE_MSG + index + " - orgName: " +
	 * Employee.getOrgName() + " is not configured in meta datas"); continue; } } if
	 * (Employee.getMethodologyCode() != null && Employee.getMethodologyCode() != ""
	 * && Employee.getMethodologyName() != null && Employee.getMethodologyName() !=
	 * "" && Employee.getOrgCode()!= null&& Employee.getOrgCode() != ""){
	 * EmployeeDbObj =
	 * EmployeeCodeMap.getOrDefault(Employee.getMethodologyCode(),null);
	 * EmployeeDbObj = EmployeeNameMap.getOrDefault(Employee.getMethodologyName(),
	 * null);
	 * 
	 * 
	 * 
	 * if (EmployeeDbObj != null) { if (EmployeeDbObj != null &&
	 * EmployeeDbObj.get_id() != null) { EmployeeDuplicateExcelList.add("Employee "
	 * + DataUploadUtils.ExcelMessages.AT_LINE_MSG + index +
	 * DataUploadUtils.ExcelMessages.DUPLICATE_MSG +
	 * " - methodologyCode & methodologyName : " + Employee.getMethodologyCode() +
	 * Employee.getMethodologyName()); continue; } } Employee EmployeeNewObj =
	 * this.saveEmployee(Employee); if (EmployeeNewObj != null) {
	 * EmployeeCodeMap.put(EmployeeNewObj.getMethodologyCode(),EmployeeNewObj);
	 * EmployeeNameMap.put(EmployeeNewObj.getMethodologyName(),EmployeeNewObj);
	 * 
	 * } EmployeeSuccessExcelList.add("Employee " +
	 * DataUploadUtils.ExcelMessages.AT_LINE_MSG + index +
	 * " - methodologyCode & methodologyName: " +
	 * EmployeeNewObj.getMethodologyCode() + EmployeeNewObj .getMethodologyName() +
	 * " saved Successfully"); } } } excelSuccessAndFailureMap.put("successList",
	 * EmployeeSuccessExcelList); excelSuccessAndFailureMap.put("duplicateList",
	 * EmployeeDuplicateExcelList); excelSuccessAndFailureMap.put("failureList",
	 * EmployeeFailureExcelList);
	 * 
	 * }else {
	 * 
	 * throw new IllegalStateException("Please do not send an empty excel"); }
	 * }catch (Exception e) { throw new AppServiceException("","",e); } logger.
	 * info(">>end of  
	 * \excelUploadEmployeeData method << excelSuccessAndFailureMap"+
	 * excelSuccessAndFailureMap); return excelSuccessAndFailureMap; }
	 * 
	 */}


