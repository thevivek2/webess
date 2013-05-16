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
public class WSUnitDAOImpl extends WSCommonDAO implements WSUnitDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eserve.web.api.dao.WSUnitDAO#getModel()
	 */
	@Override
	public WSUnitDTO getModel() {
		List<WSUnitDTO> unitDTOList = new ArrayList<WSUnitDTO>();
		WSUnitDTO dto = new WSUnitDTO();
		dto.setUnitDefineType(0);
		dto.setUnitDefineTitle("Simple");
		unitDTOList.add(dto);
		if (getJdbcTemplate().queryForInt(
				"select count(unitid) from Eserve_WAM_units") >= 2) {
			WSUnitDTO dto1 = new WSUnitDTO();
			dto1.setUnitDefineType(1);
			dto1.setUnitDefineTitle("Compound");
			unitDTOList.add(dto1);
		}
		WSUnitDTO dto2 = new WSUnitDTO();
		dto2.setWsUnitDTO(unitDTOList);
		return dto2;
	}

	@Override
	public boolean saveModel(WSUnitDTO model) {
		if (model.getUnitDefineType() == 0) {
			getJdbcTemplate().update(
					"INSERT INTO Eserve_WAM_units (Name, des) VALUES(?,?)",
					new Object[] { model.getUnitName(), model.getUnitDesc() });
		} else if (model.getUnitDefineType() == 1) {
			model.setUnitName(getUnitName(model.getUnitID()) + " of "
					+ model.getTwoUnitsRelator() +" "
					+ getUnitName(model.getSecondaryUnitID()));
			getJdbcTemplate()
					.update("INSERT INTO Eserve_WAM_compoundunits (primaryunit, relator,secondaryunit, name,des) VALUES(?,?,?,?,?)",
							new Object[] { model.getUnitID(),
									model.getTwoUnitsRelator(),
									model.getSecondaryUnitID(),
									model.getUnitName(), model.getUnitDesc() });
		}
		return true;
	}

	@Override
	public List<WSDTO> getModels() {
		RowMapper<WSUnitDTO> rowMapper = new RowMapper<WSUnitDTO>() {

			@Override
			public WSUnitDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				WSUnitDTO dto = new WSUnitDTO();
				dto.setUnitID(rs.getInt("unitid"));
				dto.setUnitName(rs.getString("name"));
				dto.setUnitDesc(rs.getString("des"));
				return dto;
			}
		};
		List listofAllUnits = getJdbcTemplate().query(
				"Select unitid, name, des from Eserve_WAM_units ", rowMapper);
		return listofAllUnits;
	}

	@Override
	public List<WSDTO> getModels(WSDTO model) {
		List listofAllUnits = new ArrayList();
		if (model instanceof WSUnitDTO) {
			RowMapper<WSUnitDTO> rowMapper = new RowMapper<WSUnitDTO>() {

				@Override
				public WSUnitDTO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					WSUnitDTO dto = new WSUnitDTO();
					dto.setUnitID(rs.getInt("unitid"));
					dto.setUnitName(rs.getString("name"));
					dto.setUnitDesc(rs.getString("des"));
					return dto;
				}
			};

			if (((WSUnitDTO) model).getUnitDefineType() == 0) {
				listofAllUnits = getJdbcTemplate().query(
						"Select unitid, name, des from Eserve_WAM_units ",
						rowMapper);
			} else {
				listofAllUnits = getJdbcTemplate()
						.query("Select cunitid as unitid, name, des from Eserve_WAM_compoundunits ",
								rowMapper);
			}
		}
		return listofAllUnits;
	}

	public String getUnitName(int unitID) {

		String sql = "select name from Eserve_WAM_units where unitid=" + unitID;
		return getJdbcTemplate().queryForObject(sql, String.class);
	}

}
