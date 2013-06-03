/**
 * WSItemServiceImpl.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSItemDAO;
import com.eserve.web.api.service.WSItemService;
import com.eserve.web.api.service.WSUserPreferenceService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dao.WSLocationDAOImpl;
import com.eserve.web.impl.dao.WSStockGroupDAOImpl;
import com.eserve.web.impl.dao.WSUnitDAOImpl;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSItemPreferenceDTO;
import com.eserve.web.impl.dto.WSSalesDTO;
import com.eserve.web.impl.dto.WSStockGroupDTO;
import com.eserve.web.impl.dto.WSStoreLocationDTO;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Service
@Named("wsItemService")
public class WSItemServiceImpl extends WSCommonService implements WSItemService,Serializable {
	
	
	private static final long serialVersionUID = -1605559716267990000L;
	
	@Inject
	@Named("wsItemDAO")
    private WSItemDAO dao;
	
	@Inject
	@Named("wsStockGroupDAO")
	WSStockGroupDAOImpl groupDAO;

	@Inject
	@Named("wsLocationDAO")
	WSLocationDAOImpl locationDao;

	@Inject
	@Named("wsUnitDAO")
	WSUnitDAOImpl unitDAOImpl;
	
	@Inject
	@Named("wsItemPreferenceDTO")
	WSItemPreferenceDTO itemPreferenceDTO;
	
	@Inject
	@Named("wsUserPreferenceService")
	WSUserPreferenceService preferenceService;
    
	@Override
	public List<WSDTO> getModels()
	{
		return dao.getModels();
	}
	
	
	
	@Override
	public boolean saveModel(WSDTO model)
	{
		return dao.saveModel(model);
	}
	
	@Override
	public WSDTO getModel(WSDTO model)
	{
		if(model instanceof WSSalesDTO)        // means Sales person wants some property of item, lets serve it
		{
			WSSalesDTO salesDTO= (WSSalesDTO) model;
			WSItemDTO itemDTO= salesDTO.getItemDTOs().get(
					salesDTO.getChangedRow());
			return dao.getModel(itemDTO);
		}
		
		WSItemDTO itemDTO = (WSItemDTO) model;
		WSItemDTO dto = new WSItemDTO();
		WSItemPreferenceDTO itemPreferenceDTO =(WSItemPreferenceDTO) preferenceService.getModel(new  WSItemPreferenceDTO());
		dto.setItemPreferenceDTO(itemPreferenceDTO);
		dto.setStockGroupDTO(new WSStockGroupDTO());
		dto.setUnitDTO(new WSUnitDTO());
		dto.setLocationDTO(new WSStoreLocationDTO());
		
		dto.setWsStockGroupDTOs(groupDAO.getGroups());
		dto.setWsLocationDTOs(locationDao.getLocations());
		
		
		WSUnitDTO unitDTO = itemDTO.getUnitDTO();
		List unitDTOList = unitDAOImpl.getModels(unitDTO);
		dto.setWsUnitDTOs(unitDTOList);
		List itemsList= dao.getModels(model);
		System.out.println("returning items of size"+itemsList.size());
		dto.setWsItemDTOs(itemsList);
		return dto;
	}
	
	
	
	@Override
	public WSDTO getModel(int modelID) {
		
		return null;
	}

}
