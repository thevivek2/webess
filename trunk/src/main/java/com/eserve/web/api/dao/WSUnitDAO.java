/**
 * WSUnitDAO.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.api.dao;

import com.eserve.web.api.core.WSDAO;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSUnitDAO extends WSDAO {
	
	public WSUnitDTO getModel();

}
