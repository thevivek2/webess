/**
 * @class:  WSCommonController.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.common;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.eserve.web.api.core.WSBaseController;
import com.eserve.web.api.core.WSDTO;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */
public class WSCommonController implements WSBaseController{

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#getModel(java.lang.String)
	 */
	@Override
	public WSDTO getModel(String modelID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#getModel(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public WSDTO getModel(WSDTO model) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#saveModel(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public boolean saveModel(WSDTO model) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#getModels()
	 */
	@Override
	public List<WSDTO> getModels() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#getModels(java.lang.String)
	 */
	@Override
	public List<WSDTO> getModels(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#updateModel(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public boolean updateModel(WSDTO model) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#getModels(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public List<WSDTO> getModels(WSDTO model) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#getRequestParameter(java.lang.String)
	 */
	@Override
	public Object getRequestParameter(String paramID) {
		FacesContext context = FacesContext.getCurrentInstance();
		return context.getExternalContext().getRequestParameterMap().get("paramID");
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#addModel(javax.faces.event.ActionEvent, com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public void addModel(ActionEvent event) {
		System.out.println("hello");
		
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSBaseController#updateModels(java.util.List)
	 */
	@Override
	public boolean updateModels(List<WSDTO> modelsList) {
		// TODO Auto-generated method stub
		return false;
	}

}
