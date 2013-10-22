/**
 * WSItemControllerImpl.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.event.ActionEvent;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.service.WSItemService;
import com.eserve.web.api.service.WSUserPreferenceService;
import com.eserve.web.api.web.WSItemController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dao.WSUnitDAOImpl;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSSalesDTO;
import com.eserve.web.impl.dto.WSSalesPreferenceDTO;
import com.eserve.web.impl.dto.WSUnitDTO;
import com.eserve.web.impl.service.WSUserPreferenceServiceImpl;

/**
 * @author Vivek Adhikari
 * 
 */
@Controller
@Named("wsItemController")
@Scope("request")
public class WSItemControllerImpl extends WSCommonController implements
		WSItemController, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6988071970780339455L;

	/**
	 * 
	 */

	@Inject
	@Named("wsItemService")
	private WSItemService service;
	
	@Inject
	@Named("wsUserPreferenceService")
	WSUserPreferenceService preferenceService;

	private WSItemDTO model;
	private boolean loadModel;
	private int rowCount = 1;
	private boolean simpleUnit = true;

	@Inject
	@Named("wsUnitDAO")
	WSUnitDAOImpl unitDAOImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eserve.web.api.web.WSItemController#addItem(javax.faces.event.ActionEvent
	 * )
	 */
	@Override
	public void addItem(ActionEvent event) {
		System.out.println("adding item");
		service.saveModel(model);
		setModel(model);

	}

	public void reSet(ActionEvent event) {
		setModel(model);
	}

	public String showCompound(int rowNumber) {
		WSUnitDTO unitDTO = new WSUnitDTO();
		System.out.println(model.getWsItemDTOs().get(rowNumber).getUnitDTO()
				.getUnitDefineType());
		unitDTO.setUnitDefineType(model.getWsItemDTOs().get(rowNumber)
				.getUnitDTO().getUnitDefineType());
		List listOFUnits = unitDAOImpl.getModels(unitDTO);
		model.getWsItemDTOs().get(rowNumber).setWsUnitDTOs(listOFUnits);

		return "";
	}

	/**
	 * @return the model
	 */
	@Override
	public WSItemDTO getModel() {
		if (model == null || isLoadModel()) {
			WSItemDTO dto = new WSItemDTO();
			WSUnitDTO unitDTO = new WSUnitDTO();
			dto.setUnitDTO(unitDTO);
			setModel(dto);
		}

		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(WSItemDTO model) {
		this.model = (WSItemDTO) service.getModel(model);

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
	 * @return the simpleUnit
	 */
	public boolean isSimpleUnit() {
		return simpleUnit;
	}

	/**
	 * @param simpleUnit
	 *            the simpleUnit to set
	 */
	public void setSimpleUnit(boolean simpleUnit) {
		this.simpleUnit = simpleUnit;
	}

	public String addRow() {
		model.getUnitDTO().setUnitDefineType(0);
		model.getWsItemDTOs().add((WSItemDTO) service.getModels(model).get(0));
		return "";
	}

	public String deleteRow() {
		if (model.getWsItemDTOs() != null && model.getWsItemDTOs().size() >= 2) {
			model.getWsItemDTOs().remove(model.getWsItemDTOs().size() - 1);
		}
		return "";
	}

	/**
	 * @return the rowCount
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount
	 *            the rowCount to set
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String updateUserPreference()
	{
		System.out.println("User preferences has been saved");
		preferenceService.saveModel(model.getItemPreferenceDTO());
		return "";
		
	}
	
	public String selectedItem()
	{
		System.out.println(model.getItemID());
		setModel(model);
		return  "";
	}
	
	
	
	@PostConstruct
	public void init() {

	}
}
