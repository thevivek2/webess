/**
 * WSCalculateServiceImpl.java
 * Vivek Adhikari
 * May 29, 2013
 */
package com.eserve.web.impl.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.service.WSCalculateService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSSalesDTO;
import com.eserve.web.impl.dto.WSSalesPreferenceDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Service
@Named("wsCalculateService")
public class WSCalculateServiceImpl extends WSCommonService implements
		WSCalculateService,Serializable {

	
	private static final long serialVersionUID = 8316800581782682607L;
	
	
	

	@Inject
	@Named("wsSalesPreferenceDTO")
	WSSalesPreferenceDTO salesPreferenceDTO; 
	
	
	@Override
	public BigDecimal getRounded(BigDecimal primary) {
		return primary.setScale(salesPreferenceDTO.getRoundUpDigit(),
				RoundingMode.HALF_UP);
	}

	
	@Override
	public BigDecimal getMultiply(BigDecimal primary, BigDecimal Secondary) {
		return getRounded(primary.multiply(Secondary));

	}

	
	@Override
	public BigDecimal getSum(List<WSDTO> models, String propertyTosum) {
		BigDecimal inDecimal = new BigDecimal(0);
		Iterator itr = models.iterator();
		while (itr.hasNext()) {
			WSItemDTO dto = (WSItemDTO) itr.next();
			inDecimal = inDecimal.add((BigDecimal) dto
					.getPropertyValue(propertyTosum));

		}

		return getRounded(inDecimal);
	}
	
	public BigDecimal getSum(BigDecimal primary, BigDecimal Secondary)
	{
		return getRounded(primary.add(Secondary));
	}

	
	
	public BigDecimal getSubStract(BigDecimal primary, BigDecimal Secondary)
	{
		return getRounded(primary).subtract(Secondary);
	}
	
	
	@Override
	public BigDecimal getDiscount(BigDecimal Value)
	{
		return getRounded(salesPreferenceDTO.getDiscount().divide(new BigDecimal(100)).multiply(Value));
		
	}
	
	@Override
	public BigDecimal getTax(BigDecimal Value)
	{
		return getRounded(salesPreferenceDTO.getTax().divide(new BigDecimal(100)).multiply(Value));
	}
	
	@Override
	public BigDecimal getVat(BigDecimal Value)
	{
		return getRounded(salesPreferenceDTO.getVat().divide(new BigDecimal(100)).multiply(Value));
	}
	
	
	@Override
	public WSDTO calculateALL(BigDecimal Value)
	{
		WSSalesDTO dto= new WSSalesDTO();
		if(salesPreferenceDTO.isCalculateTaxBeforeDiscount())
		{
			dto.setTax(getTax(Value));
			Value=getSum(Value, getTax(Value));
			dto.setDiscount(getDiscount(Value));
			Value=getSubStract(Value, getDiscount(Value));
			dto.setGrandTotalSalePrice(Value);
			
		}
		else 
		{
			dto.setDiscount(getDiscount(Value));
			Value=getSubStract(Value, getDiscount(Value));
			dto.setTax(getTax(Value));
			Value=getSum(Value, getTax(Value));
			dto.setGrandTotalSalePrice(Value);
			
		}
		return dto;
	}


	


	
	
	
	
	
	
	
	
	
	
}
