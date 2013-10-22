/**
 * @class:  WSDTO.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.api.core;

import java.io.Serializable;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
public abstract interface WSDTO extends Serializable {
	
	public int getID();
	
	public String toString();
	public Object getValue();
	
	public String getUpdateCriteria();

}
