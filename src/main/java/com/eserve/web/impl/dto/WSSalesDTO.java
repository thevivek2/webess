/**
 * WSSalesDTO.java
 * Vivek Adhikari
 * May 28, 2013
 */
package com.eserve.web.impl.dto;

import java.math.BigDecimal;
import java.util.List;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 *
 */
public class WSSalesDTO extends WSCommonDTO implements WSDTO {

	
	private static final long serialVersionUID = -1789191912947629310L;
	
	private WSSalesDTO model;
	
	private List<WSItemDTO> itemDTOs;
	private WSItemDTO itemDTO;
	
	private String party;
	
	private BigDecimal totalSalePrice;
	
	private BigDecimal discount;
	private BigDecimal tax;
	
	private BigDecimal grandTotalSalePrice;
	
	
	private WSSalesPreferenceDTO salesPreferenceDTO;
	
	private int changedRow;
	
	public enum ChangedAttribute {
	    Item,Quantity,Rate,Per
	}
	
	public ChangedAttribute changedThing;
	
	
	

	/**
	 * @return the model
	 */
	public WSSalesDTO getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(WSSalesDTO model) {
		this.model = model;
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
	 * @return the itemDTOs
	 */
	public List<WSItemDTO> getItemDTOs() {
		return itemDTOs;
	}

	/**
	 * @param itemDTOs the itemDTOs to set
	 */
	public void setItemDTOs(List<WSItemDTO> itemDTOs) {
		this.itemDTOs = itemDTOs;
	}

	/**
	 * @return the party
	 */
	public String getParty() {
		return party;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(String party) {
		this.party = party;
	}

	/**
	 * @return the totalSalePrice
	 */
	public BigDecimal getTotalSalePrice() {
		return totalSalePrice;
	}

	/**
	 * @param totalSalePrice the totalSalePrice to set
	 */
	public void setTotalSalePrice(BigDecimal totalSalePrice) {
		this.totalSalePrice = totalSalePrice;
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
	 * @return the grandTotalSalePrice
	 */
	public BigDecimal getGrandTotalSalePrice() {
		return grandTotalSalePrice;
	}

	/**
	 * @param grandTotalSalePrice the grandTotalSalePrice to set
	 */
	public void setGrandTotalSalePrice(BigDecimal grandTotalSalePrice) {
		this.grandTotalSalePrice = grandTotalSalePrice;
	}

	

	/**
	 * @return the salesPreferenceDTO
	 */
	public WSSalesPreferenceDTO getSalesPreferenceDTO() {
		return salesPreferenceDTO;
	}

	/**
	 * @param salesPreferenceDTO the salesPreferenceDTO to set
	 */
	public void setSalesPreferenceDTO(WSSalesPreferenceDTO salesPreferenceDTO) {
		this.salesPreferenceDTO = salesPreferenceDTO;
	}

	/**
	 * @return the changedThing
	 */
	public ChangedAttribute getChangedThing() {
		return changedThing;
	}

	/**
	 * @param changedThing the changedThing to set
	 */
	public void setChangedThing(ChangedAttribute changedThing) {
		this.changedThing = changedThing;
	}

	/**
	 * @return the changedRow
	 */
	public int getChangedRow() {
		return changedRow;
	}

	/**
	 * @param changedRow the changedRow to set
	 */
	public void setChangedRow(int changedRow) {
		this.changedRow = changedRow;
	}

	
	
	
	
	
	
	

}
