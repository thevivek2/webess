/**
 * CurrentStockDTO.java
 * Vivek Adhikari
 * Jun 7, 2013
 */
package com.eserve.web.impl.dto;

import java.util.List;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 *
 */
public class WSCurrentStockDTO  extends WSCommonDTO implements WSDTO  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2134797522852088251L;
	
	private int currentStockID;
	private WSItemDTO itemDTO;
	
	private List<WSCurrentStockDTO> currentStockDTOs;
	/**
	 * @return the currentStockID
	 */
	public int getCurrentStockID() {
		return currentStockID;
	}
	/**
	 * @param currentStockID the currentStockID to set
	 */
	public void setCurrentStockID(int currentStockID) {
		this.currentStockID = currentStockID;
	}
	/**
	 * @return the itemDTO
	 */
	public WSItemDTO getItemDTO() {
		return itemDTO;
	}
	/**
	 * @param itemDTO the itemDTO to set
	 */
	public void setItemDTO(WSItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	/**
	 * @return the currentStockDTOs
	 */
	public List<WSCurrentStockDTO> getCurrentStockDTOs() {
		return currentStockDTOs;
	}
	/**
	 * @param currentStockDTOs the currentStockDTOs to set
	 */
	public void setCurrentStockDTOs(List<WSCurrentStockDTO> currentStockDTOs) {
		this.currentStockDTOs = currentStockDTOs;
	}
	
	
	

}
