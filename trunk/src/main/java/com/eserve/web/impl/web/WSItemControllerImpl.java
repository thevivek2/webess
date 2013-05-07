/**
 * WSItemControllerImpl.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.web;

import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ActionEvent;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.eserve.web.api.service.WSItemService;
import com.eserve.web.api.web.WSItemController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dto.WSItemDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Controller
@Named("wsItemController")
@Scope("request")
public class WSItemControllerImpl extends WSCommonController implements WSItemController {

	private static final long serialVersionUID = -8942245932409952875L;
	
	@Inject
	@Named("wsItemService")
	private WSItemService service;
	
	private WSItemDTO model;
	private boolean loadModel;
	/* (non-Javadoc)
	 * @see com.eserve.web.api.web.WSItemController#addItem(javax.faces.event.ActionEvent)
	 */
	@Override
	public void addItem(ActionEvent event) {
		
		System.out.println("User Want to add item having");
		System.out.println("Name"+model.getItemName());
		System.out.println("Alise"+model.getItemAlieas());
		
	}
	
	
	
	
	/**
	 * @return the model
	 */
	public WSItemDTO getModel() {
		if(model==null)
		{
			setModel(new WSItemDTO());
		}
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(WSItemDTO model) {
		this.model=(WSItemDTO) service.getModels().get(0);
		
		
	}

	/**
	 * @return the loadModel
	 */
	public boolean isLoadModel() {
		return loadModel;
	}
	/**
	 * @param loadModel the loadModel to set
	 */
	public void setLoadModel(boolean loadModel) {
		this.loadModel = loadModel;
	}
	
	
}
