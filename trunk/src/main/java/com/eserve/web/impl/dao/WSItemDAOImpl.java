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
import com.eserve.web.impl.dto.WSStockGroupDTO;
import com.eserve.web.impl.dto.WSStoreLocationDTO;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 * @param <WSDTO>
 * 
 */
@Named("wsItemDAO")
public class WSItemDAOImpl extends WSCommonDAO implements WSItemDAO {

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
	public List<WSDTO> getModels(WSDTO model) {
		List<WSDTO> listModels = new ArrayList<WSDTO>();
		WSItemDTO dto = new WSItemDTO();
		dto.setStockGroupDTO(new WSStockGroupDTO());
		dto.setUnitDTO(new WSUnitDTO());
		dto.setLocationDTO(new WSStoreLocationDTO());
		dto.setWsStockGroupDTO(dao.getGroups());
		dto.setWsLocationDTOs(locationDao.getLocations());
		WSItemDTO itemDTO = (WSItemDTO) model;
		WSUnitDTO unitDTO = itemDTO.getUnitDTO();
		List unitDTOList = unitDAOImpl.getModels(unitDTO);
		dto.setWsUnitDTOs(unitDTOList);
		listModels.add(dto);
		return listModels;
	}

	@Override
	public boolean saveModel(WSDTO model) {
		if (model instanceof WSItemDTO) {
			System.out.println(((WSItemDTO) model).getItemName());
			System.out.println(((WSItemDTO) model).getItemAlieas());

			getJdbcTemplate()
					.update("INSERT INTO Eserve_WAM_Items (name, code, alias, des,unitType, hasImpactOnStock, valuationType, createdDate, availableDate, groupid) VALUES(?,?,?,?,?,?,?,?,?,?)",
							new Object[] {
									((WSItemDTO) model).getItemName(),
									((WSItemDTO) model).getItemCode(),
									((WSItemDTO) model).getItemAlieas(),
									((WSItemDTO) model).getDes(),
									((WSItemDTO) model).getUnitDTO().getUnitDefineType(),
									((WSItemDTO) model).isHasImpactOnStock()?1:0,
									((WSItemDTO) model).getValuationType(),
									new java.sql.Timestamp(new java.util.Date()
											.getTime()),
									new java.sql.Timestamp(((WSItemDTO) model)
											.getAvailableDate().getTime()),
									((WSItemDTO) model).getStockGroupDTO()
											.getGroupID() });
		}

		return true;
	}
}
