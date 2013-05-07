/**
 * WSStockGroupServiceImpl.java
 * Vivek Adhikari
 * Apr 23, 2013
 */
package com.eserve.web.impl.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.eserve.web.api.dao.WSStockGroupDAO;
import com.eserve.web.api.service.WSStockGroupService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dto.WSStockGroupDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Service
@Named("wsStockGroupService")
public class WSStockGroupServiceImpl extends WSCommonService implements WSStockGroupService{

	@Inject
	private WSStockGroupDAO dao;

	/* (non-Javadoc)
	 * @see com.eserve.web.api.service.WSStockGroupService#getAllGroups()
	 */
	@Override
	public List<WSStockGroupDTO> getAllGroups() {
		return dao.getListOfCategory();
	}
	
	
	
}
