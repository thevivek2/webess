/**
 * WSStockManagerControllerImpl.java
 * Vivek Adhikari
 * Jun 7, 2013
 */
package com.eserve.web.impl.web;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eserve.web.api.service.WSStockManageService;
import com.eserve.web.api.web.WSStockManageController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dto.WSCurrentStockDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Controller
@Named("wsStockManageController")
@Scope("request")
public class WSStockManageControllerImpl extends WSCommonController implements WSStockManageController {
	
	@Inject
	@Named("wsStockManageService")
	WSStockManageService service;
	
	private WSCurrentStockDTO model;

	/**
	 * @return the model
	 */
	public WSCurrentStockDTO getModel() {
		if(model == null )
		{
			setModel(model);
		}
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(WSCurrentStockDTO model) {
		WSCurrentStockDTO currentStockDTO = new WSCurrentStockDTO();
		this.model = (WSCurrentStockDTO) service.getModel(currentStockDTO);
	}
	
	

}
