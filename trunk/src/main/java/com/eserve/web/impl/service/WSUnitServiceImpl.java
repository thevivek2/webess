/**
 * WSUnitServiceImpl.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.impl.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.eserve.web.api.dao.WSUnitDAO;
import com.eserve.web.api.service.WSUnitService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Service
@Named("wsUnitService")
public class WSUnitServiceImpl extends WSCommonService implements WSUnitService {

	
	@Inject
	@Named("wsUnitDAO")
	WSUnitDAO dao;
	
	public WSUnitDTO getModel()
	{
		return dao.getModel();
	}
	
}
