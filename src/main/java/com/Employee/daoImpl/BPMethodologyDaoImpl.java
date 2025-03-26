package com.Employee.daoImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.Employee.dao.BPMethodologyDao;
import com.Employee.model.BPMethodology;

import Exception.AppDaoException;

@Service
public class BPMethodologyDaoImpl implements BPMethodologyDao {
	
	private static Logger logger = Logger.getLogger(BPMethodologyDaoImpl.class);

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public BPMethodology saveBPMethodology(BPMethodology BPMethodology) throws AppDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BPMethodology updateBPMethodology(BPMethodology BPMethodology) throws AppDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BPMethodology deleteBPMethodologyById(String _id) throws AppDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BPMethodology findBPMethodologyById(String _id) throws AppDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BPMethodology findAllBPMethodology() throws AppDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BPMethodology findBPMethodologyByFilter(String orgCode, String methodologyCode, String year, String period)
			throws AppDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
