/**
 * @class:  WSLogDTO.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.dto;

import java.sql.Date;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
public class WSLogDTO extends WSCommonDTO implements WSDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int logID;
	Date logDate;
	String logDesc;
	String loggedBy;
	Status status;
	
	public enum Status {
	    Completed,Inprogress,Stucked,NeedHelp
	}
	/**
	 * @return the logID
	 */
	public int getLogID() {
		return logID;
	}
	/**
	 * @param logID the logID to set
	 */
	public void setLogID(int logID) {
		this.logID = logID;
	}
	/**
	 * @return the logDate
	 */
	public Date getLogDate() {
		return logDate;
	}
	/**
	 * @param logDate the logDate to set
	 */
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	
	/**
	 * @return the logDesc
	 */
	public String getLogDesc() {
		return logDesc;
	}
	/**
	 * @param logDesc the logDesc to set
	 */
	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}
	/**
	 * @return the loggedBy
	 */
	public String getLoggedBy() {
		return loggedBy;
	}
	/**
	 * @param loggedBy the loggedBy to set
	 */
	public void setLoggedBy(String loggedBy) {
		this.loggedBy = loggedBy;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
	

}
