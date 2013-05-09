/**
 * WSUnitControllerImpl.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.impl.web;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.service.WSUnitService;
import com.eserve.web.api.web.WSUnitController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Controller
@Named("wsUnitController")
@Scope("request")
public class WSUnitControllerImpl extends WSCommonController implements
		WSUnitController {

	@Inject
	@Named("wsUnitService")
	WSUnitService service;

	private int selectedType = 0;
	private boolean simple = true;
	private boolean compound;

	private WSUnitDTO model;
	private List<WSDTO> models;

	/**
	 * @return the compound
	 */
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
		if (isCompound()) {
			System.out.println("Compound unit is going to be add");

		} else if (isSimple()) {
			System.out.println("Adding Simple unit >>>>>> ");
			service.saveModel(model);
			model.setUnitName("");
			model.setUnitDesc("");

		}
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
		if (selectedType == 1) {
			setCompound(true);
			setSimple(false);
		} else {
			setCompound(false);
			setSimple(true);
		}
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
		if (model == null) {
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

}
