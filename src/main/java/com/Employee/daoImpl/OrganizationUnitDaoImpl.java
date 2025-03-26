package com.Employee.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.Employee.dao.OrganizationUnitDao;
import com.Employee.model.OrganizationUnit;
import com.Employee.util.RequestConstants;

import Exception.AppDaoException;

@Service
@Component
public class OrganizationUnitDaoImpl  implements OrganizationUnitDao {
	
	private static Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private MongoOperations mongoOperations;

	public OrganizationUnit saveOrganizationUnit(OrganizationUnit organizationUnit) throws AppDaoException {
		logger.debug(">>>start of organizationUnit save method>>>> organizationUnit " + organizationUnit);
		try {
			organizationUnit = this.mongoOperations.save(organizationUnit, RequestConstants.Collections.COLLECTION_ORGANIZATION_UNIT);
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of saveOrganizationUnit method..........organizationUnit" + organizationUnit);
		return organizationUnit;
	}

	public OrganizationUnit updateOrganizationUnit(OrganizationUnit organizationUnit) throws AppDaoException {
		logger.debug(">>>start of organizationUnit save method>>>> organizationUnit " + organizationUnit);
		try {
			organizationUnit = this.mongoOperations.save(organizationUnit, RequestConstants.Collections.COLLECTION_ORGANIZATION_UNIT);
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of OrganizationUnit update method..........organizationUnit" + organizationUnit);
		return organizationUnit;
	}

	public OrganizationUnit deleteOrganizationUnitById(String _id) throws AppDaoException {
		logger.debug(">>>>> Start of deleteOrganizationUnitById save method................OrganizationUnit" + _id);
		OrganizationUnit organizationUnitObj = null; 
		Query searchQuery = null;
		try {
			if(_id !=  null) {
				searchQuery = new Query(Criteria.where("_id").is(_id));
				organizationUnitObj = this.mongoOperations.findAndRemove(searchQuery, OrganizationUnit.class,RequestConstants.Collections.COLLECTION_ORGANIZATION_UNIT);
			}
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of deleteOrganizationUnitById method..........OrganizationUnitById" + _id);
		return organizationUnitObj;
	}

	public OrganizationUnit findOrganizationUnitById(String _id) throws AppDaoException {
		logger.debug(">>>>> Start of findOrganizationUnitById save method................organizationUnit" + _id);
		OrganizationUnit organizationUnitObj = null; 
		Query searchQuery = null;
		try {
			if(_id !=  null) {
				searchQuery = new Query(Criteria.where("_id").is(_id));
				organizationUnitObj = this.mongoOperations.findOne(searchQuery, OrganizationUnit.class,RequestConstants.Collections.COLLECTION_ORGANIZATION_UNIT);
			}
		}catch(Exception e) {
			throw new AppDaoException("", "",e);
		}
		logger.debug("<<<<End of findOrganizationUnitById method..........OrganizationUnitById" + _id);
		return organizationUnitObj;
	}

	public List<OrganizationUnit> findAllOrganizationUnits() throws AppDaoException {
		logger.debug(">>> Start of findallOrganizationUnit method ");
		List<OrganizationUnit> organizationUnitList = null;
		Query searchQuery = null;
		try {
			organizationUnitList = this.mongoOperations.find(searchQuery, OrganizationUnit.class,RequestConstants.Collections.COLLECTION_EMPLOYEE);
		} catch (Exception e) {
			throw new AppDaoException("","",e);
		}
		logger.debug("<<<<End of findAll method..........organizationUnitList" + organizationUnitList);
		return organizationUnitList;
	}

}
