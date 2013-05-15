/**
 * 
 */
package com.eserve.web.impl.web;




import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.eserve.web.api.service.WSStockGroupService;
import com.eserve.web.api.web.WSStockGroupController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dto.WSStockGroupDTO;

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
	WSStockGroupService service;
	
	private WSStockGroupDTO model;
	private boolean loadModel;
	
	
	@Override
	public void addModel(ActionEvent event)
	{
		System.out.println("adding model>>>");
		System.out.println(model.getName());
		service.saveModel(model);
		setLoadModel(true);
		getModel();
		
	}
	
	
	
	
	/**
	 * @return the model
	 */
	public WSStockGroupDTO getModel() {
		if(model == null || isLoadModel())
		{
			setModel(model);
		}
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(WSStockGroupDTO model) {
		this.model = service.getModel();
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
