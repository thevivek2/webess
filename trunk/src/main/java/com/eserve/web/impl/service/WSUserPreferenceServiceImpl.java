/**
 * WSUserPreferenceServiceImpl.java
 * Vivek Adhikari
 * May 31, 2013
 */
package com.eserve.web.impl.service;

import javax.inject.Inject;
import javax.inject.Named;


import org.springframework.stereotype.Service;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.service.WSUserPreferenceService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dto.WSItemPreferenceDTO;
import com.eserve.web.impl.dto.WSSalesPreferenceDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Service
@Named("wsUserPreferenceService")
public class WSUserPreferenceServiceImpl extends WSCommonService implements
		WSUserPreferenceService {

	@Inject
	@Named("wsItemPreferenceDTO")
	WSItemPreferenceDTO itemPreferenceDTO;
	
	@Inject
	@Named("wsSalesPreferenceDTO")
	WSSalesPreferenceDTO salesPreferenceDTO;
	
	
	@Override
	public WSDTO getModel(WSDTO model)
	{
		if (model instanceof WSItemPreferenceDTO)
		{
			return itemPreferenceDTO;
		}
		else if ( model instanceof WSSalesPreferenceDTO)
		{
			return salesPreferenceDTO;
		}
		return null;
	}

	public boolean saveModel(WSDTO model)
	{
		if( model instanceof WSItemPreferenceDTO )
		{
			WSItemPreferenceDTO itemPreferenceDTO= (WSItemPreferenceDTO) model;
			setItemPreferenceDTO(itemPreferenceDTO);
		}
		else if ( model instanceof WSSalesPreferenceDTO)
		{
			WSSalesPreferenceDTO salesPreferenceDTO = (WSSalesPreferenceDTO) model;
			setSalesPreferenceDTO(salesPreferenceDTO);
			System.out.println("setting called inside User Preferences");
		}
		return true;
	}

	/**
	 * @param itemPreferenceDTO the itemPreferenceDTO to set
	 */
	private  void setItemPreferenceDTO(WSItemPreferenceDTO itemPreferenceDTO) {
		this.itemPreferenceDTO = itemPreferenceDTO;
	}


	/**
	 * @param salesPreferenceDTO the salesPreferenceDTO to set
	 */
	private  void setSalesPreferenceDTO(WSSalesPreferenceDTO salesPreferenceDTO) {
		this.salesPreferenceDTO = salesPreferenceDTO;
	}

	
	
	
}
