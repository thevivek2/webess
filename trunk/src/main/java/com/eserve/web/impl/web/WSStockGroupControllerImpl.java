/**
 * 
 */
package com.eserve.web.impl.web;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eserve.web.api.web.WSStockGroupController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dto.WSStockGroupDTO;
import com.eserve.web.impl.service.WSStockGroupServiceImpl;

/**
 * 
 * @author Vivek Adhikari
 *
 */
@Controller
@Named("wsStockGroupController")
@Scope("request")
public class WSStockGroupControllerImpl extends WSCommonController implements WSStockGroupController {

	@Inject
	@Named("wsStockGroupService")
	private WSStockGroupServiceImpl service;
	
	
	
	public List<WSStockGroupDTO> getListOfCategory()
	{
		System.out.println("Stock Group controller called");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return service.getAllGroups();
		
	}
	
	public String getName()
	{
	return "this is a test";
	}
	
	
	public String  getPageName()
	{
		return "stockgroups.xhtml";
	}
}
