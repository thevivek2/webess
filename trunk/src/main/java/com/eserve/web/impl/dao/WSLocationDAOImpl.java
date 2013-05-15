/**
 * WSLocationDAOImpl.java
 * Vivek Adhikari
 * May 14, 2013
 */
package com.eserve.web.impl.dao;

import javax.inject.Named;

import com.eserve.web.api.dao.WSLocationDAO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSStoreLocationDTO;

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
}
