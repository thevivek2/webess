/**
 * WSItemDTO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dto;

import java.util.Date;
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
	private List<WSUnitDTO> wsUnitDTOs;
	
	private WSUnitDTO unitDTO;
	private WSStockGroupDTO stockGroupDTO;
	private WSStoreLocationDTO locationDTO;
	/**
	 * @return the unitDTO
	 */
	public WSUnitDTO getUnitDTO() {
		return unitDTO;
	}

	/**
	 * @param unitDTO the unitDTO to set
	 */
	public void setUnitDTO(WSUnitDTO unitDTO) {
		this.unitDTO = unitDTO;
	}

	private int itemID;
	private String itemName;
	private String itemAlieas;
	private Date createdOn;
	private Date availableDate;
	private boolean hasImpactOnStock;
	private boolean vat;
	private int priceUnit;
	private String createdBy;
    private long quantity;
    private String des;
    private String itemCode;
    private int valuationType;

	

	
	
	/**
	 * @return the itemID
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
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
	 * @return the availableDate
	 */
	public Date getAvailableDate() {
		return availableDate;
	}

	/**
	 * @param availableDate the availableDate to set
	 */
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
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

	/**
	 * @return the wsUnitDTOs
	 */
	public List<WSUnitDTO> getWsUnitDTOs() {
		return wsUnitDTOs;
	}

	/**
	 * @param wsUnitDTOs the wsUnitDTOs to set
	 */
	public void setWsUnitDTOs(List<WSUnitDTO> wsUnitDTOs) {
		this.wsUnitDTOs = wsUnitDTOs;
	}

	/**
	 * @return the stockGroupDTO
	 */
	public WSStockGroupDTO getStockGroupDTO() {
		return stockGroupDTO;
	}

	/**
	 * @param stockGroupDTO the stockGroupDTO to set
	 */
	public void setStockGroupDTO(WSStockGroupDTO stockGroupDTO) {
		this.stockGroupDTO = stockGroupDTO;
	}

	/**
	 * @return the locationDTO
	 */
	public WSStoreLocationDTO getLocationDTO() {
		return locationDTO;
	}

	/**
	 * @param locationDTO the locationDTO to set
	 */
	public void setLocationDTO(WSStoreLocationDTO locationDTO) {
		this.locationDTO = locationDTO;
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
	 * @return the itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * @param itemCode the itemCode to set
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * @return the valuationType
	 */
	public int getValuationType() {
		return valuationType;
	}

	/**
	 * @param valuationType the valuationType to set
	 */
	public void setValuationType(int valuationType) {
		this.valuationType = valuationType;
	}
	
	


}