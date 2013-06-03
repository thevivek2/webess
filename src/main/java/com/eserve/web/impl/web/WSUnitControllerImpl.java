/**
 * WSUnitControllerImpl.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.impl.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.service.WSUnitService;
import com.eserve.web.api.web.WSUnitController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Controller
@Named("wsUnitController")
@Scope("request")
public class WSUnitControllerImpl extends WSCommonController implements
		WSUnitController, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6933544254503421383L;

	@Inject
	@Named("wsUnitService")
	WSUnitService service;

	private int selectedType;
	private boolean simple = true;
	private boolean compound;

	private String test;

	private WSUnitDTO model;
	private List<WSDTO> models;

	private boolean loadModel;

	public boolean isCompound() {
		return compound;
	}

	/**
	 * @param compound
	 *            the compound to set
	 */
	public void setCompound(boolean compound) {
		this.compound = compound;
	}

	public String showCompound() {
		if (getSelectedType() == 0) {
			setSimple(true);
			setCompound(false);
		} else if (getSelectedType() == 1) {
			setCompound(true);
			setSimple(false);
		}
		return "";
	}

	@Override
	public void addUnit(ActionEvent event) {
		model.setUnitDefineType(getSelectedType());
		service.saveModel(model);
		setLoadModel(true);
		model = getModel();

	}

	/**
	 * @return the selectedType
	 */
	public int getSelectedType() {
		return selectedType;
	}

	/**
	 * @param selectedType
	 *            the selectedType to set
	 */
	public void setSelectedType(int selectedType) {
		this.selectedType = selectedType;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eserve.web.api.web.WSUnitController#getModel()
	 */

	/**
	 * @return the simple
	 */
	public boolean isSimple() {
		return simple;
	}

	/**
	 * @param simple
	 *            the simple to set
	 */
	public void setSimple(boolean simple) {
		this.simple = simple;
	}

	/**
	 * @return the models
	 */
	public List<WSDTO> getModels() {
		return service.getModels();
	}

	/**
	 * @param models
	 *            the models to set
	 */
	public void setModels(List<WSDTO> models) {
		this.models = models;
	}

	@Override
	public WSUnitDTO getModel() {
		if (model == null || isLoadModel()) {
			setModel(new WSUnitDTO());
		}

		return model;

	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(WSUnitDTO model) {
		this.model = service.getModel();
	}

	/**
	 * @return the loadModel
	 */
	public boolean isLoadModel() {
		return loadModel;
	}

	/**
	 * @param loadModel
	 *            the loadModel to set
	 */
	public void setLoadModel(boolean loadModel) {
		this.loadModel = loadModel;
	}

	/**
	 * @return the test
	 */
	public String getTest() {
		return test;
	}

	/**
	 * @param test
	 *            the test to set
	 */
	public void setTest(String test) {
		this.test = test;
	}

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		String compound = context.getExternalContext().getRequestParameterMap()
				.get("isCompound");
		if (compound != null && compound.equals("true")) {
			this.compound = true;
			this.simple = false;
		}
	}

}
