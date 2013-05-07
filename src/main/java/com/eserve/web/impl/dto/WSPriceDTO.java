/**
 * WSPriceDTO.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 *
 */
public class WSPriceDTO extends WSCommonDTO implements WSDTO {
	
    
	private static final long serialVersionUID = -6480862201869980674L;
	private int itemID;
	private BigDecimal actualPrice;
	private BigDecimal marketprice;
	private Date effectiveFrom;
	private Date effectiveTo;
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
	 * @return the actualPrice
	 */
	public BigDecimal getActualPrice() {
		return actualPrice;
	}
	/**
	 * @param actualPrice the actualPrice to set
	 */
	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}
	/**
	 * @return the marketprice
	 */
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	/**
	 * @param marketprice the marketprice to set
	 */
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	/**
	 * @return the effectiveFrom
	 */
	public Date getEffectiveFrom() {
		return effectiveFrom;
	}
	/**
	 * @param effectiveFrom the effectiveFrom to set
	 */
	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}
	/**
	 * @return the effectiveTo
	 */
	public Date getEffectiveTo() {
		return effectiveTo;
	}
	/**
	 * @param effectiveTo the effectiveTo to set
	 */
	public void setEffectiveTo(Date effectiveTo) {
		this.effectiveTo = effectiveTo;
	}
	
	
	

}
