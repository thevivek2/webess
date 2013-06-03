/**
 * WSItemPreferenceDTO.java
 * Vivek Adhikari
 * May 31, 2013
 */
package com.eserve.web.impl.dto;

import javax.inject.Named;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Named("wsItemPreferenceDTO")
public class WSItemPreferenceDTO extends WSCommonDTO implements WSDTO {

	
	private static final long serialVersionUID = -6791702191173953327L;
	
	private boolean useAliasForItem=true;
	private boolean useCodeForItem=true;
	private boolean useDescForItem=false;
	private boolean enableDifferentCostingType=false;
	private boolean enableTaxInformationForItem=false;
	private boolean enaleMarekedPriceForItem=true;
	private  int roundUpDigit = 2;
	private boolean enableVendorForItem= false;
	private boolean enableGowDownsForItem=false;
	
	/**
	 * @return the useAliasForItem
	 */
	public boolean isUseAliasForItem() {
		return useAliasForItem;
	}
	/**
	 * @param useAliasForItem the useAliasForItem to set
	 */
	public void setUseAliasForItem(boolean useAliasForItem) {
		this.useAliasForItem = useAliasForItem;
	}
	/**
	 * @return the useCodeForItem
	 */
	public boolean isUseCodeForItem() {
		return useCodeForItem;
	}
	/**
	 * @param useCodeForItem the useCodeForItem to set
	 */
	public void setUseCodeForItem(boolean useCodeForItem) {
		this.useCodeForItem = useCodeForItem;
	}
	/**
	 * @return the useDescForItem
	 */
	public boolean isUseDescForItem() {
		return useDescForItem;
	}
	/**
	 * @param useDescForItem the useDescForItem to set
	 */
	public void setUseDescForItem(boolean useDescForItem) {
		this.useDescForItem = useDescForItem;
	}
	/**
	 * @return the enableDifferentCostingType
	 */
	public boolean isEnableDifferentCostingType() {
		return enableDifferentCostingType;
	}
	/**
	 * @param enableDifferentCostingType the enableDifferentCostingType to set
	 */
	public void setEnableDifferentCostingType(boolean enableDifferentCostingType) {
		this.enableDifferentCostingType = enableDifferentCostingType;
	}
	/**
	 * @return the enableTaxInformationForItem
	 */
	public boolean isEnableTaxInformationForItem() {
		return enableTaxInformationForItem;
	}
	/**
	 * @param enableTaxInformationForItem the enableTaxInformationForItem to set
	 */
	public void setEnableTaxInformationForItem(boolean enableTaxInformationForItem) {
		this.enableTaxInformationForItem = enableTaxInformationForItem;
	}
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
	 * @return the enableVendorForItem
	 */
	public boolean isEnableVendorForItem() {
		return enableVendorForItem;
	}
	/**
	 * @param enableVendorForItem the enableVendorForItem to set
	 */
	public void setEnableVendorForItem(boolean enableVendorForItem) {
		this.enableVendorForItem = enableVendorForItem;
	}
	/**
	 * @return the enaleMarekedPriceForItem
	 */
	public boolean isEnaleMarekedPriceForItem() {
		return enaleMarekedPriceForItem;
	}
	/**
	 * @param enaleMarekedPriceForItem the enaleMarekedPriceForItem to set
	 */
	public void setEnaleMarekedPriceForItem(boolean enaleMarekedPriceForItem) {
		this.enaleMarekedPriceForItem = enaleMarekedPriceForItem;
	}
	/**
	 * @return the enableGowDownsForItem
	 */
	public boolean isEnableGowDownsForItem() {
		return enableGowDownsForItem;
	}
	/**
	 * @param enableGowDownsForItem the enableGowDownsForItem to set
	 */
	public void setEnableGowDownsForItem(boolean enableGowDownsForItem) {
		this.enableGowDownsForItem = enableGowDownsForItem;
	}
	
	
	

}
