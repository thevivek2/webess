/**
 * WSItemServiceImpl.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSItemDAO;
import com.eserve.web.api.dao.WSUnitDAO;
import com.eserve.web.api.service.WSItemService;
import com.eserve.web.api.service.WSUnitService;
import com.eserve.web.api.service.WSUserPreferenceService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dao.WSLocationDAOImpl;
import com.eserve.web.impl.dao.WSStockGroupDAOImpl;
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
public class WSItemServiceImpl extends WSCommonService implements
		WSItemService, Serializable {

	private static final long serialVersionUID = -1605559716267990000L;

	@Inject
	@Named("wsItemDAO")
	private WSItemDAO dao;

	@Inject
	@Named("wsUnitDAO")
	private WSUnitDAO unitDAO;

	@Inject
	@Named("wsUnitService")
	WSUnitService unitService;

	@Inject
	@Named("wsStockGroupDAO")
	WSStockGroupDAOImpl groupDAO;

	@Inject
	@Named("wsLocationDAO")
	WSLocationDAOImpl locationDao;

	@Inject
	@Named("wsUserPreferenceService")
	WSUserPreferenceService preferenceService;

	@Override
	public List<WSDTO> getModels() {
		return dao.getModels();
	}

	@Override
	public boolean saveModel(WSDTO model) {
		return dao.saveModel(model);
	}

	@Override
	public WSDTO getModel(WSDTO model) {
		/**
		 * Example like sales person wants some property of Item
		 * 
		 */
		if (model instanceof WSSalesDTO) {
			WSSalesDTO salesDTO = (WSSalesDTO) model;
			WSItemDTO itemDTO = salesDTO.getItemDTOs().get(
					salesDTO.getChangedRow());

			WSUnitDTO unitDTO = itemDTO.getUnitDTO();
			unitDTO.setQueryFor("unitsRelation");
			List listofUnitmodels = unitDAO.getModels(unitDTO);

			Map<Integer, WSUnitDTO> relatedUnitsMap = unitService
					.getAllUnitRelationMap(listofUnitmodels,
							"#" + unitDTO.getUnitID() + "#");

			/**
			 * This DTO will retrun the unitid This unitid is responsile to
			 * calculate the markedprice of the item Based on the costing method
			 * (LIFO,FIFO), this will return the UnitID
			 * 
			 */

			WSUnitDTO dto = (WSUnitDTO) unitDAO.getModels(itemDTO).get(0);
			WSUnitDTO wsUnitDTO = relatedUnitsMap.get(dto.getUnitID());

			System.out.println("relater is" + wsUnitDTO.getTwoUnitsRelator());

			WSItemDTO newItemDTO = new WSItemDTO();
			newItemDTO.setItemID(itemDTO.getItemID());

			newItemDTO.setUnitDTO(dto);

			WSItemDTO itemFromDB = (WSItemDTO) dao.getModel(newItemDTO);

			BigDecimal old = itemFromDB.getMarkedPrice();
			old = old.multiply(wsUnitDTO.getTwoUnitsRelator());

			itemDTO.setMarkedPrice(old);

			return itemDTO;
		}

		if (model instanceof WSItemDTO) {
			WSItemDTO itemDTO = (WSItemDTO) model;

			if (itemDTO.getItemID() != 0) {

				WSItemDTO dto = new WSItemDTO();
				WSItemPreferenceDTO itemPreferenceDTO = (WSItemPreferenceDTO) preferenceService
						.getModel(new WSItemPreferenceDTO());
				dto.setItemPreferenceDTO(itemPreferenceDTO);

				dto.setStockGroupDTO(new WSStockGroupDTO());
				dto.setUnitDTO(new WSUnitDTO());
				dto.setLocationDTO(new WSStoreLocationDTO());

				WSUnitDTO uDTO = (WSUnitDTO) unitDAO.getModels(itemDTO).get(0);
				uDTO.setQueryFor("unitsRelation");
				List listofUnitmodels = unitDAO.getModels(uDTO);

				List unitDTOList = unitService.getAllRelatedUnits(
						listofUnitmodels, "#" + uDTO.getUnitID() + "#");

				dto.setWsUnitDTOs(unitDTOList);
				List itemsList = dao.getModels(model);
				System.out
						.println("returning items of size" + itemsList.size());
				dto.setWsItemDTOs(itemsList);
				return dto;

			}

			else {

				WSItemDTO dto = new WSItemDTO();
				WSItemPreferenceDTO itemPreferenceDTO = (WSItemPreferenceDTO) preferenceService
						.getModel(new WSItemPreferenceDTO());
				dto.setItemPreferenceDTO(itemPreferenceDTO);
				dto.setStockGroupDTO(new WSStockGroupDTO());
				dto.setUnitDTO(new WSUnitDTO());
				dto.setLocationDTO(new WSStoreLocationDTO());
				dto.setWsStockGroupDTOs(groupDAO.getGroups());
				dto.setWsLocationDTOs(locationDao.getLocations());

				WSUnitDTO unitDTO = itemDTO.getUnitDTO();
				List unitDTOList = unitDAO.getModels(unitDTO);
				dto.setWsUnitDTOs(unitDTOList);
				List itemsList = dao.getModels(model);
				dto.setWsItemDTOs(itemsList);
				return dto;
			}
		}

		else {
			return null;
		}
	}

	@Override
	public WSDTO getModel(int modelID) {

		return null;
	}

}
