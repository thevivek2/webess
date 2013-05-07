/**
 * @class:  WSBaseController.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.api.core;

import java.util.List;

import javax.faces.event.ActionEvent;
/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
public abstract interface WSBaseController {

	
	/**
	 *method to retrieve single model,given its ID
	 *getModel
	 *@param modelID
	 *@return
	 *WSDTO
	 *@author Vivek Adhikari
	 */
	public WSDTO getModel(String modelID);
	
	/**
	 * given the model it gives another model
	 * @param model
	 * @return model
	 * @author Vivek Adhikari
	 */
	public WSDTO getModel(WSDTO model);
	
	/**
	 *@
	 *method to save/add new model
	 *saveModel
	 *@param model
	 *boolean
	 *@author Vivek Adhikari
	 */
	public boolean saveModel(WSDTO model);
	
	/**
	 * method to retrieve list of all models
	 *getModels
	 *@return
	 *List<WSDTO>
	 *@author Vivek Adhikari
	 */
	public List<WSDTO> getModels();
	
	/**
	 *method to retrieve list of models satisfying given criteria
	 *getModels
	 *@param criteria
	 *@return
	 *List<WSDTO>
	 *@author Vivek Adhikari
	 */
	public List<WSDTO> getModels(String criteria);
	
	/**
	 *method to update model's attributes
	 *updateModel
	 *@param model
	 *boolean
	 *@author Vivek Adhikari
	 */
	public boolean updateModel(WSDTO model);
	
	/**
	 * given the model,it returns the detail of this model or the list of similar models
	 *getModels
	 *@param model
	 *@return
	 *List<WSDTO>
	 *@author Vivek Adhikari
	 */
	public List<WSDTO> getModels(WSDTO model);
	
	/**
	 * given name of the requestParmeter
	 * @param paramID
	 * @return value of the parameter
	 * @author Vivek Adhikari
	 */
	
	public Object getRequestParameter(String paramID);
	/**
	 * method to be used to add or create new model
	 *addModel
	 *@param event
	 *@param model
	 *void
	 *@author Vivek Adhikari
	 */
	public void addModel(ActionEvent event, WSDTO model);
	
	public boolean updateModels(List<WSDTO> modelsList);
}
