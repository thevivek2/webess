/**
 * @class:  WSLogServiceImpl.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;


import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSLogDAO;
import com.eserve.web.api.service.WSLogService;
import com.eserve.web.impl.common.WSCommonService;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
@Service
@Named("wsLogService")
public class WSLogServiceImpl extends WSCommonService implements WSLogService {

	
	@Inject
	@Named("wsLogDAO")
	private WSLogDAO dao;
	
	/* (non-Javadoc)
	 * @see com.eserve.web.impl.common.WSCommonService#getModels()
	 */
	
	public List<WSDTO> getModels() {
		System.out.println("Serivce sending request to the DAO to server >>>>>>>>>>>>");
		return dao.getModels();
	}
	
}
