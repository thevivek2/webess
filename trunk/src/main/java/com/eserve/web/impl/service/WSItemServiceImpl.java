/**
 * WSItemServiceImpl.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSItemDAO;
import com.eserve.web.api.service.WSItemService;
import com.eserve.web.impl.common.WSCommonService;

/**
 * @author Vivek Adhikari
 *
 */
@Service
@Named("wsItemService")
public class WSItemServiceImpl extends WSCommonService implements WSItemService {
	
	@Inject
	@Named("wsItemDAO")
    private WSItemDAO dao;
    
	public List<WSDTO> getModels()
	{
		return dao.getModels();
	}

}
