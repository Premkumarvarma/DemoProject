package com.Employee.serviceImpl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.dao.OrganizationUnitDao;
import com.Employee.model.OrganizationUnit;
import com.Employee.service.OrganizationUnitService;

import Exception.AppServiceException;

@Service
public class OrganizationUnitServiceImpl implements OrganizationUnitService {
	
	@Autowired
	private OrganizationUnitDao organizationUnitDao;
	
	private static Logger logger = LogManager.getLogger(OrganizationUnitServiceImpl.class);
	
	public OrganizationUnit saveOrganizationUnit(OrganizationUnit organizationUnit) throws AppServiceException {
		
		
		return null;
	}

	public OrganizationUnit updateOrganizationUnit(OrganizationUnit employee) throws AppServiceException {
		
		return null;
	}

	public OrganizationUnit deleteOrganizationUnitById(String _id) throws AppServiceException {
		
		return null;
	}

	public OrganizationUnit findOrganizationUnitById(String _id) throws AppServiceException {
		
		return null;
	}

	public List<OrganizationUnit> findAllOrganizationUnits() throws AppServiceException {
		
		return null;
	}

}
