package com.Employee.service;

import java.util.List;

import com.Employee.model.OrganizationUnit;

import Exception.AppServiceException;

public interface OrganizationUnitService {
	
	OrganizationUnit saveOrganizationUnit (OrganizationUnit organizationUnit) throws AppServiceException;

	OrganizationUnit updateOrganizationUnit (OrganizationUnit employee) throws AppServiceException;

	OrganizationUnit deleteOrganizationUnitById (String _id) throws AppServiceException;

	OrganizationUnit findOrganizationUnitById (String _id) throws AppServiceException;

	List<OrganizationUnit> findAllOrganizationUnits() throws AppServiceException;

}
