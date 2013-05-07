/**
 * WSUnitDTO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dto;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 *
 */
public class WSUnitDTO  extends WSCommonDTO implements WSDTO {

	private static final long serialVersionUID = -1127404152488419620L;
	
	private int ID;
	private String unitName;
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}
	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	
	
	

}
