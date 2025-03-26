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

	public BPMethodology saveBPMethodology(BPMethodology bPMethodology) throws AppDaoException {
		logger.error("start of saveBPMethodology method");
		try {
			bPMethodology = mongoOperations.save(bPMethodology);
		}catch (Exception e) {
			throw new AppDaoException("","",e);
		}
		logger.error("end of saveBPMethodology method");
		return bPMethodology;
	}

	public BPMethodology updateBPMethodology(BPMethodology bPMethodology) throws AppDaoException {
		logger.error("start of updateBPMethodology method");
		try {
			bPMethodology = mongoOperations.save(bPMethodology);
		}catch (Exception e) {
			throw new AppDaoException("","",e);
		}
		logger.error("end of updateBPMethodology method");
		return bPMethodology;
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
