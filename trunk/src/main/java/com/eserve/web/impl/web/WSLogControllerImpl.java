/**
 * @class:  WSLogControllerImpl.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.web;

import java.util.List;


import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.service.WSLogService;
import com.eserve.web.api.web.WSLogController;
import com.eserve.web.impl.common.WSCommonController;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */

@Controller
@Named("wsLogController")
@Scope("request")
public class WSLogControllerImpl extends WSCommonController implements WSLogController{
	
	@Inject
	private WSLogService service;
	
	/* (non-Javadoc)
	 * @see com.eserve.web.impl.common.WSCommonController#getModels()
	 */
	@Override
	public List<WSDTO> getModels() {
		System.out.println("controller gets request >>>>>>>>>>>");
		System.out.println("Controller calling service to serve the request >>>>>>>>>>>>");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service.getModels();
	}
	
	public String reaload()
	{
		return "";
	}
	
	

}
