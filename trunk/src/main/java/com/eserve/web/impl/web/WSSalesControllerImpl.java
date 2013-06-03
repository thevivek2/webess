/**
 * WSSalesControllerImpl.java
 * Vivek Adhikari
 * May 27, 2013
 */
package com.eserve.web.impl.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.service.WSCalculateService;
import com.eserve.web.api.service.WSItemService;
import com.eserve.web.api.service.WSSalesService;
import com.eserve.web.api.service.WSUnitService;
import com.eserve.web.api.service.WSUserPreferenceService;
import com.eserve.web.api.web.WSSalesController;
import com.eserve.web.impl.common.WSCommonController;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSSalesDTO;
import com.eserve.web.impl.dto.WSSalesDTO.ChangedAttribute;
import com.eserve.web.impl.dto.WSUnitDTO;
import com.eserve.web.impl.dto.WSSalesPreferenceDTO;
import com.eserve.web.impl.service.WSCalculateServiceImpl;

/**
 * @author Vivek Adhikari
 * 
 */
@Named("wsSalesController")
@Controller
@Scope("session")
public class WSSalesControllerImpl extends WSCommonController implements
		WSSalesController, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7611751971226883358L;

	@Inject
	@Named("wsSalesService")
	WSSalesService service;
	
	
	
	@Inject
	@Named("wsUserPreferenceService")
	WSUserPreferenceService preferenceService;

	public WSDTO model;
	
	

	private String today = new java.util.Date().toString();

	@Override
	public void saleItems(ActionEvent e) {
		if (service.saveModel(model))
		setModel(model);

	}

	public String addRow() {

		WSSalesDTO dto = new WSSalesDTO();
		WSItemDTO itemDTO = new WSItemDTO();
		itemDTO.setListAllItems(true);
		dto.setItemDTO(itemDTO);
		dto.setChangedThing(null);
		WSSalesDTO newSalesDTO = (WSSalesDTO) service.getModel(dto);
		WSSalesDTO oldSalesDTO = (WSSalesDTO) model;
		oldSalesDTO.getItemDTOs().add(newSalesDTO.getItemDTOs().get(0));
		return "";
	}

	public String deleteRow() {
		
		WSSalesDTO salesDTO= (WSSalesDTO) model;
		if(salesDTO.getItemDTOs() != null && salesDTO.getItemDTOs().size() >= 2)
		{
			salesDTO.getItemDTOs().remove(salesDTO.getItemDTOs().size()-1);
		}

		return "";
	}

	public String reSet() {
		setModel(model);
		return "";
	}

	/**
	 * @return the today
	 */
	public String getToday() {
		return today;
	}

	/**
	 * @param today
	 *            the today to set
	 */
	public void setToday(String today) {
		this.today = today;
	}

	public String selectedItem(int rowNumber) {
		WSSalesDTO salesDTO = (WSSalesDTO) model;
		salesDTO.setChangedRow(rowNumber);
		salesDTO.setChangedThing(ChangedAttribute.Item);
		this.model = service.getModel(salesDTO);
		return "";
	}

	public String quantityChanged(int rowNumber) {

		WSSalesDTO salesDTO = (WSSalesDTO) model;
		salesDTO.setChangedRow(rowNumber);
		salesDTO.setChangedThing(ChangedAttribute.Quantity);
		this.model = service.getModel(salesDTO);
		return "";
	}

	public String perChanged(int rowNumber) {

		WSSalesDTO salesDTO = (WSSalesDTO) model;
		salesDTO.setChangedRow(rowNumber);
		salesDTO.setChangedThing(ChangedAttribute.Per);
		this.model = service.getModel(salesDTO);
		return "";
	}

	public String rateChanged(int rowNumber) {
		quantityChanged(rowNumber);
		return "";
	}

	/**
	 * @return the model
	 */
	public WSDTO getModel() {
		if (model == null) {
			setModel(model);
		}
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(WSDTO model) {

		WSSalesDTO dto = new WSSalesDTO();
		WSItemDTO itemDTO = new WSItemDTO();
		itemDTO.setListAllItems(true);
		dto.setItemDTO(itemDTO);
		this.model = service.getModel(dto);
	}
	
	public String updateUserPreference()
	{
		WSSalesDTO salesDTO = (WSSalesDTO) model;
		WSSalesPreferenceDTO pdto = salesDTO.getSalesPreferenceDTO();
		preferenceService.saveModel(pdto);
		return "";
		
		
		
	}

	
	

}
