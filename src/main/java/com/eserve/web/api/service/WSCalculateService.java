/**
 * WSCalculateService.java
 * Vivek Adhikari
 * May 29, 2013
 */
package com.eserve.web.api.service;

import java.math.BigDecimal;
import java.util.List;

import com.eserve.web.api.core.WSBaseService;
import com.eserve.web.api.core.WSDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSCalculateService extends WSBaseService {

	/**
	 * @param primary
	 * @param Secondary
	 * @return
	 */
	public  BigDecimal getMultiply(BigDecimal primary, BigDecimal Secondary);

	/**
	 * @param primary
	 * @return
	 */
	BigDecimal getRounded(BigDecimal primary);

	


	/**
	 * @param models
	 * @param propertyTosum
	 * @return
	 */
	BigDecimal getSum(List<WSDTO> models, String propertyTosum);

	/**
	 * @param Value
	 * @return
	 */
	BigDecimal getDiscount(BigDecimal Value);

	/**
	 * @param Value
	 * @return
	 */
	BigDecimal getTax(BigDecimal Value);

	/**
	 * @param Value
	 * @return
	 */
	BigDecimal getVat(BigDecimal Value);

	/**
	 * @param Value
	 * @return
	 */
	WSDTO calculateALL(BigDecimal Value);

}
