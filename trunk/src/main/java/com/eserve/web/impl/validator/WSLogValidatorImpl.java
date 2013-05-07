/**
 * @class:  WSLogValidatorImpl.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eserve.web.impl.common.WSCommonValidator;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
public class WSLogValidatorImpl extends WSCommonValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
