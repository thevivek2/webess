/**
 * @class:  WSCommonService.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.common;

import java.util.List;


import com.eserve.web.api.core.WSBaseService;
import com.eserve.web.api.core.WSDTO;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */

public class WSCommonService implements WSBaseService {

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseService#getModel(java.lang.String)
	 */
	@Override
	public WSDTO getModel(String modelID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseService#saveModel(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public boolean saveModel(WSDTO model) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseService#getModels()
	 */
	@Override
	public List<WSDTO> getModels() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseService#getModels(java.lang.String)
	 */
	@Override
	public List<WSDTO> getModels(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseService#updateModel(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public boolean updateModel(WSDTO model) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseService#getModels(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public List<WSDTO> getModels(WSDTO model) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseService#updateModels(java.util.List)
	 */
	@Override
	public boolean updateModels(List<WSDTO> modelsList) {
		// TODO Auto-generated method stub
		return false;
	}

}
