/**
 * WSUnitDAOImpl.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.eserve.web.api.dao.WSStockGroupDAO;
import com.eserve.web.api.dao.WSUnitDAO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSUnitDTO;


/**
 * @author Vivek Adhikari
 *
 */
@Named("wsUnitDAO")
public class WSUnitDAOImpl  extends WSCommonDAO implements WSUnitDAO {

	/* (non-Javadoc)
	 * @see com.eserve.web.api.dao.WSUnitDAO#getModel()
	 */
	@Override
	public WSUnitDTO getModel() {
		List<WSUnitDTO> unitDTOList= new ArrayList<WSUnitDTO>();
		WSUnitDTO dto= new WSUnitDTO();
		dto.setUnitDefineType(0);
		dto.setUnitDefineTitle("Simple");
		
		WSUnitDTO dto1= new WSUnitDTO();
		dto1.setUnitDefineType(1);
		dto1.setUnitDefineTitle("Compound");
		
		unitDTOList.add(dto);
		unitDTOList.add(dto1);
		
		WSUnitDTO dto2= new  WSUnitDTO();
		dto2.setWsUnitDTO(unitDTOList);
		return dto2;
	}
	
	

}
