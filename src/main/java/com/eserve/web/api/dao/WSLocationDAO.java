/**
 * WSLocationDAO.java
 * Vivek Adhikari
 * May 14, 2013
 */
package com.eserve.web.api.dao;

import com.eserve.web.api.core.WSDAO;
import com.eserve.web.impl.dto.WSStoreLocationDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSLocationDAO extends WSDAO {

	
	public WSStoreLocationDTO getModel();

	
	boolean saveModel(WSStoreLocationDTO model);

}
