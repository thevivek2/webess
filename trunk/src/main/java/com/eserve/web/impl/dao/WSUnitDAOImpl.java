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
import com.eserve.web.impl.dto.WSItemDTO;
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
		dto.setUnitDefineTitle("Units at Top of the Level");
		unitDTOList.add(dto);
		if (getJdbcTemplate().queryForInt(
				"select count(unitid) from Eserve_WAM_units") >= 1) {
			WSUnitDTO dto1 = new WSUnitDTO();
			dto1.setUnitDefineType(1);
			dto1.setUnitDefineTitle("Relational Unit ");
			unitDTOList.add(dto1);
		}
		WSUnitDTO dto2 = new WSUnitDTO();
		dto2.setWsUnitDTO(unitDTOList);
		return dto2;
	}

	@Override
	public boolean saveModel(WSUnitDTO model) {
		getJdbcTemplate()
					.update("INSERT INTO Eserve_WAM_units (parentid, relator,name, des) VALUES(?,?,?,?)",
							new Object[] { model.getUnitDefineType()==0 ? 0:model.getParentID(),
									model.getUnitDefineType()==0 ? 1: model.getTwoUnitsRelator(),
									model.getUnitName(),
									model.getUnitDesc() });
		
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
			
			
			
			if (((WSUnitDTO) model).getQueryFor() !=null && ((WSUnitDTO) model).getQueryFor().equalsIgnoreCase("unitsRelation"))
			{
				
				
				RowMapper<WSUnitDTO> rowMapper = new RowMapper<WSUnitDTO>() {

					@Override
					public WSUnitDTO mapRow(ResultSet rs, int arg1)
							throws SQLException {
						WSUnitDTO dto = new WSUnitDTO();
						dto.setUnitID(rs.getInt("unitid"));
						dto.setParentID(rs.getInt("parentid"));
						dto.setRelationByID(rs.getString("relation"));
						dto.setRelationByALL(rs.getString("allnames"));
						return dto;
					}
				};

				String strSQL = ""
						+ "SELECT unitid, "
						+ "       Getparentunitidbyid(unitid) AS parentid, "
						+ "       Gettwounitrelator(unitid)   AS relator, "
						+ "       Getrelation(unitid)         AS relation, "
						+ "       Getancestryunit(unitid)     AS allnames "
						+ "FROM   eserve_wam_units";
				listofAllUnits = getJdbcTemplate().query(
						strSQL,
							rowMapper);
			
		}
		else 
		{
			System.out.println("returning with else condition");
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

			
			listofAllUnits = getJdbcTemplate().query(
						"Select unitid, name, des from Eserve_WAM_units ",
						rowMapper);
				
				}
		}
		
		if(model instanceof WSItemDTO)
		{
			System.out.println("following item is selected"+((WSItemDTO) model).getItemID());
			RowMapper<WSUnitDTO> rowMapper = new RowMapper<WSUnitDTO>() {

				@Override
				public WSUnitDTO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					WSUnitDTO dto = new WSUnitDTO();
					dto.setUnitID(rs.getInt("unit"));
					dto.setUnitName(rs.getString("name"));
					dto.setUnitDesc(rs.getString("des"));
					
					return dto;
				}
			};
			String strSQL = ""
					+ "SELECT t1.unit, "
					+ "       t2.des, "
					+ "       t2.name "
					+ "FROM   eserve_wam_stockin t1 "
					+ "       INNER JOIN eserve_wam_units t2 "
					+ "               ON t1.unit = t2.unitid "
					+ "WHERE  itemid = " +((WSItemDTO) model).getItemID();
			listofAllUnits = getJdbcTemplate().query(
					strSQL,
					rowMapper);
			
		}
		return listofAllUnits;
	}

	public String getUnitName(int unitID) {

		String sql = "select name from Eserve_WAM_units where unitid=" + unitID;
		return getJdbcTemplate().queryForObject(sql, String.class);
	}

}
