/**
 * WSUnitDAOImpl.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.eserve.web.api.core.WSDTO;
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
	
	
	@Override
	public boolean saveModel(WSUnitDTO model)
	{
		getJdbcTemplate().update("INSERT INTO Eserve_WAM_units (Name, des) VALUES(?,?)",
		        new Object[] { model.getUnitName(), model.getUnitDesc() });
		return true;
	}
	
	@Override
	public List<WSDTO> getModels() {
		RowMapper<WSUnitDTO> rowMapper= new RowMapper<WSUnitDTO>() {

			@Override
			public WSUnitDTO mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WSUnitDTO dto= new WSUnitDTO();
				dto.setUnitID(1);
				dto.setUnitName(rs.getString("name"));
				return dto;
			}
		};
		List listofAllUnits=getJdbcTemplate().query("Select name from Eserve_WAM_units ", rowMapper);
		return listofAllUnits;
	}

	
	

}
