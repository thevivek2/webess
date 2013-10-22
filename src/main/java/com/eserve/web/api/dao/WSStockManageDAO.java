/**
 * WSStockManageDAO.java
 * Vivek Adhikari
 * Jun 7, 2013
 */
package com.eserve.web.api.dao;

import com.eserve.web.api.core.WSDAO;
import com.eserve.web.api.core.WSDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSStockManageDAO  extends WSDAO  {

	/**
	 * @param model
	 * @return
	 */
	WSDTO getModel(WSDTO model);

}
