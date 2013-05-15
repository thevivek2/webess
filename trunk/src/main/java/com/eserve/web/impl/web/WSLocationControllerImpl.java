/**
 * WSLocationControllerImpl.java
 * Vivek Adhikari
 * May 14, 2013
 */
package com.eserve.web.impl.web;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eserve.web.api.service.WSLocationService;
import com.eserve.web.api.web.WSLocationController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dto.WSStoreLocationDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Controller
@Named("wsLocationController")
@Scope("request")
public class WSLocationControllerImpl extends WSCommonController implements WSLocationController {
	
	@Inject
	@Named("wsLocationService")
	WSLocationService service;
	
	private WSStoreLocationDTO model;
	
	
	@Override
	public void addLocation(ActionEvent event) {
		System.out.println("adding location >>>>");
		service.saveModel(model);
		this.model=new WSStoreLocationDTO();
		
		}

	/**
	 * @return the model
	 */
	public WSStoreLocationDTO getModel() {
		if(model == null)
		{
			setModel(model);
		}
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(WSStoreLocationDTO model) {
		this.model = service.getModel();
	}
	
	
	

}
