package com.eserve.web.impl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.eserve.web.api.dao.WSStockGroupDAO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSStockGroupDTO;

/**
 * @author Vivek Adhikari
 *
 */
@Named("wsStockGroupDAO")
public class WSStockGroupDAOImpl extends WSCommonDAO implements WSStockGroupDAO {

	
	public List<WSStockGroupDTO> getListOfCategory()
	{
		List<WSStockGroupDTO> listOfCategory= new ArrayList<WSStockGroupDTO>();
		
		WSStockGroupDTO dto= new WSStockGroupDTO();
		dto.setID(2);
		dto.setName("Stock Group 2");
		listOfCategory.add(dto);
		
		WSStockGroupDTO dto1= new WSStockGroupDTO();
		dto1.setID(3);
		dto1.setName("Stock Group 3");
		listOfCategory.add(dto1);
		WSStockGroupDTO dto2= new WSStockGroupDTO();
		dto2.setID(4);
		dto2.setName("Stock Group 4");
		listOfCategory.add(dto2);
		return listOfCategory;
		
	}
}
