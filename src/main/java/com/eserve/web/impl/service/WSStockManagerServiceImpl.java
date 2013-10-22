/**
 * WSStockManagerServiceImpl.java
 * Vivek Adhikari
 * Jun 7, 2013
 */
package com.eserve.web.impl.service;


import javax.inject.Inject;
import javax.inject.Named;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSStockManageDAO;
import com.eserve.web.api.service.WSStockManageService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dto.WSSalesDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Named("wsStockManageService")
public class WSStockManagerServiceImpl extends WSCommonService implements WSStockManageService {
	
	
	@Inject
	@Named("wsStockManageDAO")
	WSStockManageDAO dao;
	
	
	@Override
	public WSDTO getModel(WSDTO model)
	{
		return dao.getModel(model);
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
	
	@Override
	public boolean updateModel (WSDTO model)
	{
		boolean result = false;
		WSSalesDTO salesDTO = (WSSalesDTO) model;
		WSSalesDTO dto= (WSSalesDTO) dao.getModel(salesDTO);
		if(dto.isResult())
		{
			salesDTO.setCaseUpdate(dto.getCaseUpdate());
			result= dao.updateModel(salesDTO);
			return result;
			
		}
		
		return false;
	}

}
