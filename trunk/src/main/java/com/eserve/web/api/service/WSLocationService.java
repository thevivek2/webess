/**
 * WSLocationService.java
 * Vivek Adhikari
 * May 14, 2013
 */
package com.eserve.web.api.service;

import com.eserve.web.api.core.WSBaseService;
import com.eserve.web.impl.dto.WSStoreLocationDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSLocationService  extends WSBaseService {

	
	public WSStoreLocationDTO getModel();

	
	public boolean saveModel(WSStoreLocationDTO model);

}
