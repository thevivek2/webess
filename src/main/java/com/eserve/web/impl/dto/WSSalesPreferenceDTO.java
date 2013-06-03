/**
 * WSUserPreference.java
 * Vivek Adhikari
 * May 29, 2013
 */
package com.eserve.web.impl.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.inject.Named;


import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Named("wsSalesPreferenceDTO")
public class WSSalesPreferenceDTO extends WSCommonDTO implements WSDTO {

	private static final long serialVersionUID = -2598336029995954376L;

	private  int roundUpDigit = 3;
	private int roundUpDigitForPercentage=1;
	private   BigDecimal tax = new BigDecimal(13).setScale(roundUpDigitForPercentage,RoundingMode.HALF_UP);
	private BigDecimal  vat = new BigDecimal(10).setScale(roundUpDigitForPercentage,RoundingMode.HALF_UP);
	private  BigDecimal discount = new BigDecimal(10).setScale(roundUpDigitForPercentage,RoundingMode.HALF_UP);
	private  boolean calculateTaxBeforeDiscount = true;
	
	
	
	
	/**
	 * @return the roundUpDigit
	 */
	public int getRoundUpDigit() {
		return roundUpDigit;
	}
	/**
	 * @param roundUpDigit the roundUpDigit to set
	 */
	public void setRoundUpDigit(int roundUpDigit) {
		this.roundUpDigit = roundUpDigit;
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
	 * @return the calculateTaxBeforeDiscount
	 */
	public boolean isCalculateTaxBeforeDiscount() {
		return calculateTaxBeforeDiscount;
	}
	/**
	 * @param calculateTaxBeforeDiscount the calculateTaxBeforeDiscount to set
	 */
	public void setCalculateTaxBeforeDiscount(boolean calculateTaxBeforeDiscount) {
		this.calculateTaxBeforeDiscount = calculateTaxBeforeDiscount;
	}
	/**
	 * @return the roundUpDigitForPercentage
	 */
	public int getRoundUpDigitForPercentage() {
		return roundUpDigitForPercentage;
	}
	/**
	 * @param roundUpDigitForPercentage the roundUpDigitForPercentage to set
	 */
	public void setRoundUpDigitForPercentage(int roundUpDigitForPercentage) {
		this.roundUpDigitForPercentage = roundUpDigitForPercentage;
	}
	
	

	

}
