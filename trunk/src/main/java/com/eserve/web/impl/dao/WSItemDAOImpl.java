/**
 * WSItemDAOImpl.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.eserve.web.api.dao.WSItemDAO;
import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSItemDTO;

/**
 * @author Vivek Adhikari
 * @param <WSDTO>
 *
 */
@Named("wsItemDAO")
public class WSItemDAOImpl  extends WSCommonDAO implements WSItemDAO{

	@Inject
	@Named("wsStockGroupDAO")
	WSStockGroupDAOImpl dao;
	
	@Inject
	@Named("wsLocationDAO")
	WSLocationDAOImpl locationDao;
	
	public List<WSDTO> getModels()
	{
		List<WSDTO> listModels = new ArrayList<WSDTO>();
		WSItemDTO dto= new WSItemDTO();
		dto.setWsStockGroupDTO(dao.getGroups());
		dto.setWsLocationDTOs(locationDao.getLocations());
		listModels.add(dto);
		return listModels;
	}
	
}
