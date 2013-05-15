/**
 * WSLocationServiceImpl.java
 * Vivek Adhikari
 * May 14, 2013
 */
package com.eserve.web.impl.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.eserve.web.api.dao.WSLocationDAO;
import com.eserve.web.api.service.WSLocationService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dto.WSStoreLocationDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Service
@Named("wsLocationService")
public class WSLocationServiceImpl extends WSCommonService implements WSLocationService{
	
	@Inject
	@Named("wsLocationDAO")
	WSLocationDAO dao;
	
	@Override
	public WSStoreLocationDTO getModel()
	{
		return dao.getModel();
		
	}
	
	@Override
	public boolean saveModel(WSStoreLocationDTO model)
	{
		return dao.saveModel(model);
	}

}
