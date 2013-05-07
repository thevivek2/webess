/**
 * @class:  WSBaseValidator.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.api.core;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
public abstract interface WSBaseValidator {
	
	/**
	 *Description:validate the data on submit
	 *validateData
	 *@param dto
	 *@return
	 *boolean
	 *@author Vivek Adhikari
	 */
	public boolean validateData(WSDTO dto);

}
