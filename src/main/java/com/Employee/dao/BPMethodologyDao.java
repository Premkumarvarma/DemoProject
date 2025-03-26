package com.Employee.dao;

import com.Employee.model.BPMethodology;

import Exception.AppDaoException;

public interface BPMethodologyDao {
	
	
	BPMethodology saveBPMethodology (BPMethodology BPMethodology)throws AppDaoException;
	
	BPMethodology updateBPMethodology (BPMethodology BPMethodology)throws AppDaoException;
	
	BPMethodology deleteBPMethodologyById (String _id)throws AppDaoException;
	
	BPMethodology findBPMethodologyById (String _id)throws AppDaoException;
	
	BPMethodology findAllBPMethodology ()throws AppDaoException;
	
	BPMethodology findBPMethodologyByFilter (String orgCode, String methodologyCode, String year,String period)throws AppDaoException;






}
