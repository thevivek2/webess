/**
 * WSErrorHandlerImpl.java
 * Vivek Adhikari
 * May 17, 2013
 */
package com.eserve.web.impl.web;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Vivek Adhikari
 *
 */
@Controller
@Named("wsErrorHandler")
@Scope("request")
public class WSErrorHandlerImpl {
	
	private boolean error=true;

	/**
	 * @return the error
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(boolean error) {
		this.error = error;
	}
	
	

}
