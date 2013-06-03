/**
 * @class:  WSBaseService.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.api.core;

import java.util.List;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
public abstract interface WSBaseService {
	
	/**
	 *method to retrieve single model,given its ID
	 *getModel
	 *@param modelID
	 *@return
	 *WSDTO
	 *@author Vivek Adhikari
	 */
	public WSDTO getModel(int modelID);
	
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
	 * given the list of WSDTO model, it will update the model
	 * @param modelsList
	 * @return boolean, update status
	 * @author Vivek Adhikari
	 */
	
	public boolean updateModels(List<WSDTO> modelsList);

	/**
	 * given the WSDTO model, it will return the same model 
	 * @param model
	 * @return
	 */
	public WSDTO getModel(WSDTO model);

}
