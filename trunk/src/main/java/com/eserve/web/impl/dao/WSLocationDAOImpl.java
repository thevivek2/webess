/**
 * WSLocationDAOImpl.java
 * Vivek Adhikari
 * May 14, 2013
 */
package com.eserve.web.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.eserve.web.api.dao.WSLocationDAO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSStoreLocationDTO;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Named("wsLocationDAO")
public class WSLocationDAOImpl extends WSCommonDAO implements WSLocationDAO {

	@Override
	public WSStoreLocationDTO getModel() {
		return new WSStoreLocationDTO();
	}

	@Override
	public boolean saveModel(WSStoreLocationDTO model) {
		System.out.println("Adding location");
		getJdbcTemplate()
				.update("INSERT INTO Eserve_WAM_locations (name, alias,code, address,inuse,createdon) VALUES(?,?,?,?,?,?)",
						new Object[] {
								model.getName(),
								model.getAlias(),
								model.getCode(),
								model.getAddress(),
								model.isCurrentlyInUse() ? 1 : 0,
								new java.sql.Timestamp(new java.util.Date()
										.getTime()) });
		return true;
	}
	
	public List<WSStoreLocationDTO> getLocations()
	{
		RowMapper<WSStoreLocationDTO> rowMapper= new RowMapper<WSStoreLocationDTO>() {

			@Override
			public WSStoreLocationDTO mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WSStoreLocationDTO dto= new WSStoreLocationDTO();
				dto.setLocationID(rs.getInt("locationid"));
				dto.setName(rs.getString("name"));
				return dto;
			}
		};
		List<WSStoreLocationDTO> listofAllLocations=getJdbcTemplate().query("Select locationid, name from Eserve_WAM_locations ", rowMapper);
		return listofAllLocations;
	}
}
