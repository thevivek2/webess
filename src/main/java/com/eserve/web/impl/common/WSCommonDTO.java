/**
 * @class:  WSCommonDTO.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.common;

import com.eserve.web.api.core.WSDTO;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
public class WSCommonDTO implements WSDTO {


	private static final long serialVersionUID = 2L;

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDTO#getID()
	 */
	@Override
	public int getID() {
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDTO#getValue()
	 */
	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDTO#getUpdateCriteria()
	 */
	@Override
	public String getUpdateCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

}
