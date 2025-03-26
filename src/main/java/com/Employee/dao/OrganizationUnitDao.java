package com.Employee.dao;

import java.util.List;

import com.Employee.model.OrganizationUnit;

import Exception.AppDaoException;

public interface OrganizationUnitDao {
	
	OrganizationUnit saveOrganizationUnit (OrganizationUnit organizationUnit) throws AppDaoException;

	OrganizationUnit updateOrganizationUnit (OrganizationUnit employee) throws AppDaoException;

	OrganizationUnit deleteOrganizationUnitById (String _id) throws AppDaoException;

	OrganizationUnit findOrganizationUnitById (String _id) throws AppDaoException;

	List<OrganizationUnit> findAllOrganizationUnits() throws AppDaoException;

}
