/**
 * WSLocationDTO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dto;

import java.sql.Date;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 *
 */
public class WSStoreLocationDTO extends WSCommonDTO implements WSDTO  {
	

	private static final long serialVersionUID = -5478098730334064201L;
	
	private int ID;
	private String locationName;
	private boolean isCurrentlyInUse;
	private Date createdOn;
	private int createdBy;
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
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return the isCurrentlyInUse
	 */
	public boolean isCurrentlyInUse() {
		return isCurrentlyInUse;
	}
	/**
	 * @param isCurrentlyInUse the isCurrentlyInUse to set
	 */
	public void setCurrentlyInUse(boolean isCurrentlyInUse) {
		this.isCurrentlyInUse = isCurrentlyInUse;
	}
	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * @return the createdBy
	 */
	public int getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	
	

}
