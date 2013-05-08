/**
 * WSUnitService.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.api.service;

import com.eserve.web.api.core.WSBaseService;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSUnitService  extends WSBaseService {
	
	public WSUnitDTO getModel();
	
	

}
