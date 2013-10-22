/**
 * WSUnitDTO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Named;


import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 *
 */

@Named("wsUnitDTO")
public class WSUnitDTO  extends WSCommonDTO implements WSDTO {

	private static final long serialVersionUID = -1127404152488419620L;
	
	
	
	private int unitID=0;
	private int markedPriceUnitID;
	private String unitName;
	private String unitDesc;
	private int secondaryUnitID;
    private BigDecimal twoUnitsRelator;
    private int parentID=0;
    
    private String relationByID;
    private String relationByALL;
    
    private String queryFor;
    
   
   
    /**
	 * @return the queryFor
	 */
	public String getQueryFor() {
		return queryFor;
	}
	/**
	 * @param queryFor the queryFor to set
	 */
	public void setQueryFor(String queryFor) {
		this.queryFor = queryFor;
	}
	/**
	 * @return the parentID
	 */
	public int getParentID() {
		return parentID;
	}
	/**
	 * @param parentID the parentID to set
	 */
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	private int unitDefineType=0;
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
	public BigDecimal getTwoUnitsRelator() {
		return twoUnitsRelator;
	}
	/**
	 * @param twoUnitsRelator the twoUnitsRelator to set
	 */
	public void setTwoUnitsRelator(BigDecimal twoUnitsRelator) {
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
	/**
	 * @return the secondaryUnitID
	 */
	public int getSecondaryUnitID() {
		return secondaryUnitID;
	}
	/**
	 * @param secondaryUnitID the secondaryUnitID to set
	 */
	public void setSecondaryUnitID(int secondaryUnitID) {
		this.secondaryUnitID = secondaryUnitID;
	}
	/**
	 * @return the relationByID
	 */
	public String getRelationByID() {
		return relationByID;
	}
	/**
	 * @param relationByID the relationByID to set
	 */
	public void setRelationByID(String relationByID) {
		this.relationByID = relationByID;
	}
	/**
	 * @return the relationByALL
	 */
	public String getRelationByALL() {
		return relationByALL;
	}
	/**
	 * @param relationByALL the relationByALL to set
	 */
	public void setRelationByALL(String relationByALL) {
		this.relationByALL = relationByALL;
	}
	/**
	 * @return the markedPriceUnitID
	 */
	public int getMarkedPriceUnitID() {
		return markedPriceUnitID;
	}
	/**
	 * @param markedPriceUnitID the markedPriceUnitID to set
	 */
	public void setMarkedPriceUnitID(int markedPriceUnitID) {
		this.markedPriceUnitID = markedPriceUnitID;
	}
	
	
	
	
	
	
	

}
