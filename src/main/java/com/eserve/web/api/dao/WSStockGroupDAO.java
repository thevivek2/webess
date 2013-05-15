
package com.eserve.web.api.dao;

import java.util.List;

import com.eserve.web.api.core.WSDAO;
import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.dto.WSStockGroupDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSStockGroupDAO extends WSDAO {
	List<WSStockGroupDTO> getListOfCategory();

	WSStockGroupDTO getModel();
	
	List<WSDTO> getModels();
}
