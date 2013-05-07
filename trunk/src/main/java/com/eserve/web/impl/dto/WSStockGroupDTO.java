/**
 * @author Vivek Adhikari
 */
package com.eserve.web.impl.dto;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

public class WSStockGroupDTO  extends WSCommonDTO implements WSDTO {
	
	
	private static final long serialVersionUID = -199947225827661643L;
	private int  ID;
	private String Name;
	private int parentID;
	
	
	
	
	
	
	
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
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
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
	
	
	

}
