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
import com.eserve.web.impl.dto.WSUnitDTO;

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
	
	@Inject
	@Named("wsUnitDAO")
	WSUnitDAOImpl unitDAOImpl;
	
	@Override
	public List<WSDTO> getModels(WSDTO model)
	{
		List<WSDTO> listModels = new ArrayList<WSDTO>();
		WSItemDTO dto= new WSItemDTO();
		dto.setWsStockGroupDTO(dao.getGroups());
		dto.setWsLocationDTOs(locationDao.getLocations());	
		WSItemDTO itemDTO= (WSItemDTO) model;
		WSUnitDTO unitDTO = itemDTO.getUnitDTO();
		List unitDTOList= unitDAOImpl.getModels(unitDTO);
		dto.setWsUnitDTOs(unitDTOList);
		listModels.add(dto);
		return listModels;
	}
	
}
