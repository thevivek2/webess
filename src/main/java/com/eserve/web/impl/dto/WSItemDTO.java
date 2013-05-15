/**
 * WSItemDTO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dto;

import java.sql.Date;
import java.util.List;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 * 
 */
public class WSItemDTO extends WSCommonDTO implements WSDTO {

	private static final long serialVersionUID = -8942317932409952875L;

	
	private List<WSStockGroupDTO> wsStockGroupDTO;
	private List<WSStoreLocationDTO> wsLocationDTOs;
	private int ID;
	private String itemName;
	private String itemAlieas;
	private Date createdOn;
	private Date onStockFrom;
	private boolean hasImpactOnStock;
	private boolean vat;
	private int priceUnit;
	private String createdBy;
    private long quantity;

	

	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName
	 *            the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the itemAlieas
	 */
	public String getItemAlieas() {
		return itemAlieas;
	}

	/**
	 * @param itemAlieas
	 *            the itemAlieas to set
	 */
	public void setItemAlieas(String itemAlieas) {
		this.itemAlieas = itemAlieas;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn
	 *            the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the wsStockGroupDTO
	 */
	public List<WSStockGroupDTO> getWsStockGroupDTO() {
		return wsStockGroupDTO;
	}

	/**
	 * @param wsStockGroupDTO the wsStockGroupDTO to set
	 */
	public void setWsStockGroupDTO(List<WSStockGroupDTO> wsStockGroupDTO) {
		this.wsStockGroupDTO = wsStockGroupDTO;
	}

	/**
	 * @return the onStockFrom
	 */
	public Date getOnStockFrom() {
		return onStockFrom;
	}

	/**
	 * @param onStockFrom the onStockFrom to set
	 */
	public void setOnStockFrom(Date onStockFrom) {
		this.onStockFrom = onStockFrom;
	}
	
	/**
	 * @return the hasImpactOnStock
	 */
	public boolean isHasImpactOnStock() {
		return hasImpactOnStock;
	}

	/**
	 * @param hasImpactOnStock the hasImpactOnStock to set
	 */
	public void setHasImpactOnStock(boolean hasImpactOnStock) {
		this.hasImpactOnStock = hasImpactOnStock;
	}

	/**
	 * @return the vat
	 */
	public boolean isVat() {
		return vat;
	}

	/**
	 * @param vat the vat to set
	 */
	public void setVat(boolean vat) {
		this.vat = vat;
	}

	/**
	 * @return the priceUnit
	 */
	public int getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @param priceUnit the priceUnit to set
	 */
	public void setPriceUnit(int priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @return the wsLocationDTOs
	 */
	public List<WSStoreLocationDTO> getWsLocationDTOs() {
		return wsLocationDTOs;
	}

	/**
	 * @param wsLocationDTOs the wsLocationDTOs to set
	 */
	public void setWsLocationDTOs(List<WSStoreLocationDTO> wsLocationDTOs) {
		this.wsLocationDTOs = wsLocationDTOs;
	}


}
