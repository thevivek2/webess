/**
 * WSUnitDTO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dto;

import java.util.List;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 *
 */
public class WSUnitDTO  extends WSCommonDTO implements WSDTO {

	private static final long serialVersionUID = -1127404152488419620L;
	
	private int unitID;
	private String unitName;
	private String unitDesc;
    private float twoUnitsRelator;
    
    private int unitDefineType;
    private String unitDefineTitle;
	
	private List<WSUnitDTO> wsUnitDTO;
	
	
	/**
	 * @return the unitID
	 */
	public int getUnitID() {
		return unitID;
	}
	/**
	 * @param unitID the unitID to set
	 */
	public void setUnitID(int unitID) {
		this.unitID = unitID;
	}
	/**
	 * @return the unitDesc
	 */
	public String getUnitDesc() {
		return unitDesc;
	}
	/**
	 * @param unitDesc the unitDesc to set
	 */
	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}
	
	/**
	 * @return the twoUnitsRelator
	 */
	public float getTwoUnitsRelator() {
		return twoUnitsRelator;
	}
	/**
	 * @param twoUnitsRelator the twoUnitsRelator to set
	 */
	public void setTwoUnitsRelator(float twoUnitsRelator) {
		this.twoUnitsRelator = twoUnitsRelator;
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
	/**
	 * @return the unitDefineType
	 */
	public int getUnitDefineType() {
		return unitDefineType;
	}
	/**
	 * @param unitDefineType the unitDefineType to set
	 */
	public void setUnitDefineType(int unitDefineType) {
		this.unitDefineType = unitDefineType;
	}
	/**
	 * @return the unitDefineTitle
	 */
	public String getUnitDefineTitle() {
		return unitDefineTitle;
	}
	/**
	 * @param unitDefineTitle the unitDefineTitle to set
	 */
	public void setUnitDefineTitle(String unitDefineTitle) {
		this.unitDefineTitle = unitDefineTitle;
	}
	/**
	 * @return the wsUnitDTO
	 */
	public List<WSUnitDTO> getWsUnitDTO() {
		return wsUnitDTO;
	}
	/**
	 * @param wsUnitDTO the wsUnitDTO to set
	 */
	public void setWsUnitDTO(List<WSUnitDTO> wsUnitDTO) {
		this.wsUnitDTO = wsUnitDTO;
	}
	
	
	
	

}
