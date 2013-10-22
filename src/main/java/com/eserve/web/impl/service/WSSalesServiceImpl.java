/**
 * WSSalesServiceImpl.java
 * Vivek Adhikari
 * May 27, 2013
 */
package com.eserve.web.impl.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSItemDAO;
import com.eserve.web.api.dao.WSUnitDAO;
import com.eserve.web.api.service.WSCalculateService;
import com.eserve.web.api.service.WSItemService;
import com.eserve.web.api.service.WSSalesService;
import com.eserve.web.api.service.WSUnitService;
import com.eserve.web.api.service.WSUserPreferenceService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSSalesDTO;
import com.eserve.web.impl.dto.WSSalesDTO.ChangedAttribute;
import com.eserve.web.impl.dto.WSUnitDTO;
import com.eserve.web.impl.dto.WSSalesPreferenceDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Service
@Named("wsSalesService")
public class WSSalesServiceImpl extends WSCommonService implements
		WSSalesService, Serializable {

	private static final long serialVersionUID = -5285835364944193450L;

	@Inject
	@Named("wsItemDAO")
	private WSItemDAO dao;

	@Inject
	@Named("wsUnitDAO")
	private WSUnitDAO unitDAO;

	@Inject
	@Named("wsCalculateService")
	WSCalculateService cService;

	@Inject
	@Named("wsUnitService")
	WSUnitService unitService;

	@Inject
	@Named("wsItemService")
	WSItemService itemService;

	@Inject
	@Named("wsUserPreferenceService")
	WSUserPreferenceService preferenceService;

	@Override
	public WSDTO getModel(WSDTO model) {
		WSSalesDTO salesDTO = (WSSalesDTO) model;

		if (salesDTO.getChangedThing() != null
				&& salesDTO.getChangedThing().equals(ChangedAttribute.Item)) {
			WSItemDTO itemDTO = salesDTO.getItemDTOs().get(
					salesDTO.getChangedRow());
			List aa = unitService.getModels(itemDTO);
			itemDTO.setWsUnitDTOs(aa);
			itemDTO.getUnitDTO().setUnitID(0);
			salesDTO.getItemDTOs().set(salesDTO.getChangedRow(), itemDTO);

		}

		else if ((salesDTO.getChangedThing() != null && salesDTO
				.getChangedThing().equals(ChangedAttribute.Quantity))
				|| (salesDTO.getChangedThing() != null && salesDTO
						.getChangedThing().equals(ChangedAttribute.Rate))) {
			WSItemDTO itemDTO = salesDTO.getItemDTOs().get(
					salesDTO.getChangedRow());
			if (itemDTO.getMarkedPrice() != null) {
				itemDTO.setTotalPrice(cService.getMultiply(
						itemDTO.getMarkedPrice(),
						new BigDecimal(itemDTO.getQuantity())));
			}

			List list = salesDTO.getItemDTOs();
			salesDTO.getItemDTOs().set(salesDTO.getChangedRow(), itemDTO);

			salesDTO.setTotalSalePrice(cService.getSum(list, "totalPrice"));
			WSSalesDTO calculated = (WSSalesDTO) cService.calculateALL(salesDTO
					.getTotalSalePrice());

			salesDTO.setTax(calculated.getTax());
			salesDTO.setDiscount(calculated.getDiscount());
			salesDTO.setGrandTotalSalePrice(calculated.getGrandTotalSalePrice());

		}

		else if (salesDTO.getChangedThing() != null
				&& salesDTO.getChangedThing().equals(ChangedAttribute.Per)) {

			WSItemDTO test = salesDTO.getItemDTOs().get(
					salesDTO.getChangedRow());

			WSItemDTO hello = (WSItemDTO) itemService.getModel(salesDTO);
			test.setMarkedPrice(hello.getMarkedPrice());
			if (test.getMarkedPrice() != null) {
				test.setTotalPrice(cService.getMultiply(test.getMarkedPrice(),
						new BigDecimal(test.getQuantity())));
			}
			List list = salesDTO.getItemDTOs();
			salesDTO.getItemDTOs().set(salesDTO.getChangedRow(), test);

			salesDTO.setTotalSalePrice(cService.getSum(list, "totalPrice"));
			WSSalesDTO calculated = (WSSalesDTO) cService.calculateALL(salesDTO
					.getTotalSalePrice());

			salesDTO.setTax(calculated.getTax());
			salesDTO.setDiscount(calculated.getDiscount());
			salesDTO.setGrandTotalSalePrice(calculated.getGrandTotalSalePrice());

		}

		else {

			WSSalesPreferenceDTO salesPreferenceDTO = (WSSalesPreferenceDTO) preferenceService
					.getModel(new WSSalesPreferenceDTO());
			salesDTO.setSalesPreferenceDTO(salesPreferenceDTO);
			List listOfSaleItems = new ArrayList();
			WSUnitDTO unitDTO = new WSUnitDTO();
			WSItemDTO itemDTO = salesDTO.getItemDTO();
			List listAllItems = dao.getModels(itemDTO);
			itemDTO.setWsItemDTOs(listAllItems);
			itemDTO.setUnitDTO(unitDTO);
			listOfSaleItems.add(itemDTO);
			salesDTO.setItemDTOs(listOfSaleItems);

		}
		return salesDTO;

	}
	
	/**
	 * This method is responsible to save the sale
	 * if tax,vat,discount for individul are not calulcated
	 * this will be calculated from here 
	 * 
	 */

	@Override
	public boolean saveModel(WSDTO model) {
		WSSalesDTO salesDTO = (WSSalesDTO) model;
		Iterator itr= salesDTO.getItemDTOs().iterator();
		int i=0;
		while(itr.hasNext())
		{
			
			WSItemDTO  itemDTO = (WSItemDTO) itr.next();
			itemDTO.setDiscount(cService.getDiscount(itemDTO.getTotalPrice()));
			itemDTO.setTax(cService.getTax(itemDTO.getTotalPrice()));
			i++;
		}
		return dao.saveModel(salesDTO);
	}
	
	/**
	 * This will update the Current Stock
	 * Current stock will be updated as the Costing type
	 * @param model is the model which contains the property of the item that is going for sale
	 * @return true if the operation is sucessfull
	 * 
	 * how it works
	 * it get the item id and unit id and quantity that user want to know
	 * if item having same unit, quantity and item is found in the current stock, it will delete the that row 
	 * from current stock table
	 * 
	 * if not, it will check all the rows of that item in the current stock table , if same itemid , unit id 
	 * found but quantity is not equal but qantity in stock > quantity of sales person
	 * it will substract the quantity , calculate total price of remaining quantity and update that row
	 * 
	 * if not, it will check all the rows of that item in the current stock table, and gets all the r
	 */
	public boolean updateModel (WSDTO model)
	{
		boolean result = false;
		WSSalesDTO salesDTO = (WSSalesDTO) model;
		salesDTO.setCaseCheck(1);
		WSSalesDTO dto= (WSSalesDTO) dao.getModel(salesDTO);
		if(dto.isResult())
		{
			salesDTO.setCaseUpdate(salesDTO.getCaseUpdate());
			result= dao.updateModel(salesDTO);
			return result;
			
		}
		
		return false;
	}

}
