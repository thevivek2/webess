package com.eserve.web.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSStockGroupDAO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSStockGroupDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Named("wsStockGroupDAO")
public class WSStockGroupDAOImpl extends WSCommonDAO implements WSStockGroupDAO {

	public List<WSStockGroupDTO> getListOfCategory() {
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eserve.web.api.dao.WSStockGroupDAO#getModel()
	 */
	@Override
	public WSStockGroupDTO getModel() {
		WSStockGroupDTO dto = new WSStockGroupDTO();
		WSStockGroupDTO dto1 = new WSStockGroupDTO();
		dto1.setGroupID(0);
		dto1.setName("This is Parent");
		List<WSStockGroupDTO> list = getGroups();
		list.add(0,dto1);
		dto.setGroups(list);
		return dto;

	}
	
	public List<WSStockGroupDTO> getGroups()
	{
		List<WSStockGroupDTO> list = new ArrayList<WSStockGroupDTO>();

		RowMapper<WSStockGroupDTO> rowMapper = new RowMapper<WSStockGroupDTO>() {

			@Override
			public WSStockGroupDTO mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WSStockGroupDTO dto = new WSStockGroupDTO();
				dto.setGroupID(rs.getInt("groupID"));
				dto.setName(rs.getString("name"));
				return dto;
			}
		};
		list = getJdbcTemplate().query(
				"SELECT groupID,GetParentIDByID(groupID) as parentid , GetAncestry(groupID) as name  FROM Eserve_WAM_groups; ", rowMapper);
		return list;
	}

	@Override
	public boolean saveModel(WSDTO model) {
		if (model instanceof WSStockGroupDTO) {
			System.out.println("saving group");
			getJdbcTemplate()
					.update("INSERT INTO Eserve_WAM_groups (name, alias,des, parentid,createdon) VALUES(?,?,?,?,?)",
							new Object[] {
									((WSStockGroupDTO) model).getName(),
									((WSStockGroupDTO) model).getAlias(),
									((WSStockGroupDTO) model).getDes(),
									((WSStockGroupDTO) model).getParentID(),
									new java.sql.Timestamp(new java.util.Date()
											.getTime()) });
		}
		return true;
	}

}
