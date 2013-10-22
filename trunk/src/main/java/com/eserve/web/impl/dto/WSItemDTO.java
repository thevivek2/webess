/**
 * WSItemDTO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 * 
 */
public class WSItemDTO extends WSCommonDTO {

	private static final long serialVersionUID = -8942317932409952875L;

	
	private List<WSStockGroupDTO> wsStockGroupDTOs;
	private List<WSStoreLocationDTO> wsLocationDTOs;
	private List<WSUnitDTO> wsUnitDTOs;
	
	private List<WSItemDTO> wsItemDTOs;
	
	private WSUnitDTO unitDTO;
	private WSStockGroupDTO stockGroupDTO;
	private WSStoreLocationDTO locationDTO;
	
	private WSItemDTO wsItemDTO;
	
	private WSItemPreferenceDTO itemPreferenceDTO;
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
	
	
	private boolean listAllItems;

	private int itemID = 0;
	private String itemName;
	private String itemAlias;
	private String des;
    private String itemCode;
	private Date createdOn;
	private Date availableDate;
	private boolean hasImpactOnStock=true;
	private boolean vatApplicable;
	private String createdBy;
    private float quantity=1;
    private int costingType;
    
    
    private float unitPrice;
    private BigDecimal markedPrice;
   
    private BigDecimal totalPrice;
    
    private float dutyFee;
    
    private BigDecimal vat;
    private BigDecimal tax;
    private BigDecimal discount;
    
    
    private int vendor;
    
    private String searchCriteria ;


	

	

    public  Object getPropertyValue(String propertyName){
    	
    	if(propertyName.equalsIgnoreCase("totalPrice"))
    	{
    		return this.totalPrice;
    	}
    	
    	return null;
    	
    }
	
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
	 * @return the itemAlias
	 */
	public String getItemAlias() {
		return itemAlias;
	}

	/**
	 * @param itemAlias the itemAlias to set
	 */
	public void setItemAlias(String itemAlias) {
		this.itemAlias = itemAlias;
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
	public float getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the wsStockGroupDTOs
	 */
	public List<WSStockGroupDTO> getWsStockGroupDTOs() {
		return wsStockGroupDTOs;
	}

	/**
	 * @param wsStockGroupDTOs the wsStockGroupDTOs to set
	 */
	public void setWsStockGroupDTOs(List<WSStockGroupDTO> wsStockGroupDTOs) {
		this.wsStockGroupDTOs = wsStockGroupDTOs;
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
	 * @return the vatApplicable
	 */
	public boolean isVatApplicable() {
		return vatApplicable;
	}

	/**
	 * @param vatApplicable the vatApplicable to set
	 */
	public void setVatApplicable(boolean vatApplicable) {
		this.vatApplicable = vatApplicable;
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
	 * @return the costingType
	 */
	public int getCostingType() {
		return costingType;
	}

	/**
	 * @param costingType the costingType to set
	 */
	public void setCostingType(int costingType) {
		this.costingType = costingType;
	}

	/**
	 * @return the wsItemDTOs
	 */
	public List<WSItemDTO> getWsItemDTOs() {
		return wsItemDTOs;
	}

	/**
	 * @param wsItemDTOs the wsItemDTOs to set
	 */
	public void setWsItemDTOs(List<WSItemDTO> wsItemDTOs) {
		this.wsItemDTOs = wsItemDTOs;
	}

	/**
	 * @return the wsItemDTO
	 */
	public WSItemDTO getWsItemDTO() {
		return wsItemDTO;
	}

	/**
	 * @param wsItemDTO the wsItemDTO to set
	 */
	public void setWsItemDTO(WSItemDTO wsItemDTO) {
		this.wsItemDTO = wsItemDTO;
	}

	/**
	 * @return the listAllItems
	 */
	public boolean isListAllItems() {
		return listAllItems;
	}

	/**
	 * @param listAllItems the listAllItems to set
	 */
	public void setListAllItems(boolean listAllItems) {
		this.listAllItems = listAllItems;
	}

	/**
	 * @return the unitPrice
	 */
	public float getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	

	

	/**
	 * @return the markedPrice
	 */
	public BigDecimal getMarkedPrice() {
		return markedPrice;
	}

	/**
	 * @param markedPrice the markedPrice to set
	 */
	public void setMarkedPrice(BigDecimal markedPrice) {
		this.markedPrice = markedPrice;
	}

	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the vendor
	 */
	public int getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(int vendor) {
		this.vendor = vendor;
	}

	public float getDutyFee() {
		return dutyFee;
	}

	public void setDutyFee(float dutyFee) {
		this.dutyFee = dutyFee;
	}

	/**
	 * @return the itemPreferenceDTO
	 */
	public WSItemPreferenceDTO getItemPreferenceDTO() {
		return itemPreferenceDTO;
	}

	/**
	 * @param itemPreferenceDTO the itemPreferenceDTO to set
	 */
	public void setItemPreferenceDTO(WSItemPreferenceDTO itemPreferenceDTO) {
		this.itemPreferenceDTO = itemPreferenceDTO;
	}

	/**
	 * @return the vat
	 */
	public BigDecimal getVat() {
		return vat;
	}

	/**
	 * @param vat the vat to set
	 */
	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}

	/**
	 * @return the tax
	 */
	public BigDecimal getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * @return the searchCriteria
	 */
	public String getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	
	
	
	


}
