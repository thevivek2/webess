/**
 * @author Vivek Adhikari
 */
package com.eserve.web.impl.dto;

import java.util.List;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

public class WSStockGroupDTO  extends WSCommonDTO implements WSDTO {
	
	
	private static final long serialVersionUID = -199947225827661643L;
	private int  groupID;
	private String name;
	private int parentID=0;
	private String alias;
	private String des;
	
	private List<WSStockGroupDTO> groups;
	
	
	
	/**
	 * @return the groupID
	 */
	public int getGroupID() {
		return groupID;
	}
	/**
	 * @param groupID the groupID to set
	 */
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * @return the des
	 */
	public String getDes() {
		return des;
	}
	/**
	 * @param des the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	/**
	 * @return the groups
	 */
	public List<WSStockGroupDTO> getGroups() {
		return groups;
	}
	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<WSStockGroupDTO> groups) {
		this.groups = groups;
	}
	
	
	
	
	
	

}
