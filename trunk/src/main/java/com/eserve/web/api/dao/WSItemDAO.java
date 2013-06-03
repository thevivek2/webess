/**
 * WSItemDAO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.api.dao;

import com.eserve.web.api.core.WSDAO;
import com.eserve.web.api.core.WSDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSItemDAO extends WSDAO {

	/**
	 * @param model
	 * @return
	 */
	WSDTO getModel(WSDTO model);

}
