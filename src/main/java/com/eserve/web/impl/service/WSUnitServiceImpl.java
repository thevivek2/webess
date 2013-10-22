/**
 * WSUnitServiceImpl.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.impl.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSUnitDAO;
import com.eserve.web.api.service.WSUnitService;
import com.eserve.web.impl.common.WSCommonService;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Service
@Named("wsUnitService")
public class WSUnitServiceImpl extends WSCommonService implements WSUnitService {

	private static final String UNIT_SEPERATOR = "->";
	private static final String RELATOR_SEPERATOR = "::";
	private static final String ID_SEPERATOR = "#";

	@Inject
	@Named("wsUnitDAO")
	WSUnitDAO dao;

	@Override
	public List<WSDTO> getModels() {
		return dao.getModels();
	}

	@Override
	public boolean saveModel(WSUnitDTO model) {
		return dao.saveModel(model);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.eserve.web.api.service.WSUnitService#getModel()
	 */
	@Override
	public WSUnitDTO getModel() {
		return dao.getModel();
	}

	@Override
	public List<WSDTO> getModels(WSDTO model) {

		if (model instanceof WSItemDTO) {
			WSItemDTO itemDTO = (WSItemDTO) model;
			WSUnitDTO unitDTO = itemDTO.getUnitDTO();
			unitDTO.setQueryFor("unitsRelation");
			List listofUnitmodels = dao.getModels(unitDTO);
			WSUnitDTO dto = (WSUnitDTO) dao.getModels(model).get(0);
			List allRealedUnits = getAllRelatedUnits(listofUnitmodels,
					ID_SEPERATOR + dto.getUnitID() + ID_SEPERATOR);
			return allRealedUnits;

		} else {
			return dao.getModels(model);
		}
	}

	@Override
	public WSDTO getModel(WSDTO model) {
		List listofUnitmodels = dao.getModels(model);
		WSUnitDTO unitDTO = (WSUnitDTO) model;
		unitDTO.setQueryFor("unitsRelation");
		List relationOfUnits = dao.getModels(unitDTO);
		getAllRelatedUnits(listofUnitmodels, "#2#");
		return null;
	}

	@Override
	public Map<Integer, WSUnitDTO> getAllUnitRelationMap(List test,
			String selectedUnit) {
		List<WSUnitDTO> allRelation = new ArrayList<WSUnitDTO>();
		List allRelatedUnits = getActualRelation(test, selectedUnit);
		System.out.println("Relation of " + selectedUnit
				+ "is with other units is related by  " + allRelatedUnits);
		Map<Integer, WSUnitDTO> unitMAP = new HashMap<Integer, WSUnitDTO>();

		for (int i = 0; allRelatedUnits != null && i < allRelatedUnits.size(); i++) {
			unitMAP.putAll(getMapOfRelation(allRelatedUnits.get(i).toString(),
					selectedUnit));

		}
		return unitMAP;
	}

	public List<WSUnitDTO> getAllRelatedUnits(List test, String selectedUnit) {

		List<WSUnitDTO> allRelation = new ArrayList<WSUnitDTO>();
		List allRelatedUnits = getActualRelation(test, selectedUnit);
		System.out.println("Relation of " + selectedUnit
				+ "is with other units is related by  " + allRelatedUnits);
		Map<Integer, WSUnitDTO> unitMAP = new HashMap<Integer, WSUnitDTO>();

		for (int i = 0; allRelatedUnits != null && i < allRelatedUnits.size(); i++) {
			unitMAP.putAll(getMapOfRelation(allRelatedUnits.get(i).toString(),
					selectedUnit));

		}

		allRelation = new ArrayList<WSUnitDTO>(unitMAP.values());
		return allRelation;

	}

	/**
	 * @author Vivek Adhikari
	 * @param listOfRelatedUnits
	 *            , this param should contain list of WSunitDTO having property
	 *            relationByALL(String) relationByALL should be in the format of
	 *            10::Packet#2# ->1::KG#1# this means kg and packet are related
	 *            , Kg is parent of Packet, 10 packet = 1kg 10::Packet#2# = 10:
	 *            relator, Packet:name of Unit ,2(inside ##) is ID of that unit
	 * 
	 * @param unitID
	 *            , this param is #(Unitid)# , which user want related Unit
	 *            relation
	 * @return This method will return all the unit relation of this
	 *         UnitID(String) added in List
	 * 
	 */
	public List getActualRelation(List listOfRelatedUnits, String unitID) {

		Iterator itr = listOfRelatedUnits.iterator();
		int count = 0;
		int maxRelated = 0;
		int maxSeperator = 0;

		while (itr.hasNext()) {
			WSUnitDTO unitDTO = (WSUnitDTO) itr.next();
			if (unitDTO.getRelationByALL().contains(unitID)) {
				if (StringUtils.countOccurrencesOf(unitDTO.getRelationByALL(),
						UNIT_SEPERATOR) > maxSeperator
						|| StringUtils.countOccurrencesOf(
								unitDTO.getRelationByALL(), UNIT_SEPERATOR) == 0) {
					maxSeperator = StringUtils.countOccurrencesOf(
							unitDTO.getRelationByALL(), UNIT_SEPERATOR);

					maxRelated = count;
				}

			}
			count++;
		}

		WSUnitDTO wsUnitDTO = (WSUnitDTO) listOfRelatedUnits.get(maxRelated);

		String test12 = wsUnitDTO.getRelationByALL();
		List<String> allRelatedUnits = new ArrayList<String>();
		allRelatedUnits.add(test12);
		Iterator itr1 = listOfRelatedUnits.iterator();

		while (itr1.hasNext()) {
			WSUnitDTO unitDTO = (WSUnitDTO) itr1.next();
			String another = unitDTO.getRelationByALL();
			if (another.contains(unitID) && !test12.contains(another)) {
				allRelatedUnits.add(another);
			}

		}

		return allRelatedUnits;
	}

	/**
	 * 
	 * @param stringHavingRelation
	 * @param selectedUnit
	 * @return List of WSUnitDTO which are related with selected Unit
	 * @return List of WSUnitDTO having property unitID, unitName and
	 *         twoUnitsRelator twoUnitsRelator is the relation between
	 *         selectedUnit and unit in respective WSUnitDTO
	 */
	public static Map<Integer, WSUnitDTO> getMapOfRelation(
			String stringHavingRelation, String selectedUnit) {

		Map<Integer, WSUnitDTO> unitMAP = new HashMap<Integer, WSUnitDTO>();

		String[] param = stringHavingRelation.split(UNIT_SEPERATOR);
		int count1 = 0;

		for (String uniqueUnit : param) {

			if (uniqueUnit.contains(selectedUnit)) {
				break;
			}

			count1++;
		}

		for (int i = 0; i < param.length; i++) {

			String unitName = "";
			String unitID = "";

			String regex = RELATOR_SEPERATOR + "(.*?)" + ID_SEPERATOR;
			String regax1 = ID_SEPERATOR + "(.*?)" + ID_SEPERATOR;

			Pattern p = Pattern.compile(regex);
			Matcher matcher = p.matcher(param[i]);
			if (matcher.find()) {
				unitName = matcher.group(1);

			}

			Pattern p1 = Pattern.compile(regax1);
			Matcher matcher1 = p1.matcher(param[i]);
			if (matcher1.find()) {
				unitID = matcher1.group(1);

			}

			WSUnitDTO unitDTO = new WSUnitDTO();
			unitDTO.setUnitID(Integer.parseInt(unitID));
			unitDTO.setUnitName(unitName);

			unitDTO.setTwoUnitsRelator(getRelation(param, i, count1));
			// System.out.println("get Relation called with i >>"+i+"count >>"+count1);
			unitMAP.put(Integer.parseInt(unitID), unitDTO);

		}

		return unitMAP;

	}

	/**
	 * 
	 * @param Array
	 *            of stringHavingUnitRelation like {100::grams#3# ,10::Packet#2#
	 *            ,1::KG#1#}
	 * @param elementAT
	 *            , index of current element
	 * @param relationRequiredFor
	 *            , index of required element
	 * @return
	 */
	public static BigDecimal getRelation(String[] stringHavingUnitRelation,
			int elementAT, int relationRequiredFor) {
		BigDecimal result;
		if (elementAT == relationRequiredFor) {
			return new BigDecimal(1);

		} else if (elementAT < relationRequiredFor) {

			String[] stringHavingRelator = stringHavingUnitRelation[elementAT]
					.split("::");
			String relator = stringHavingRelator[0];
			BigDecimal calculated = new BigDecimal(relator);
			result = new BigDecimal(1).multiply(calculated);
			return result.multiply(getRelation(stringHavingUnitRelation,
					elementAT + 1, relationRequiredFor));
		} else {

			String[] stringHavingRelator = stringHavingUnitRelation[elementAT - 1]
					.split("::");
			String relator = stringHavingRelator[0];
			BigDecimal calculated = new BigDecimal(relator);
			result = new BigDecimal(1).divide(calculated, 8,
					RoundingMode.HALF_UP);
			return result.multiply(getRelation(stringHavingUnitRelation,
					elementAT - 1, relationRequiredFor));
		}
	}

	/**
	 * this main method can be used to test. so commented and leaved
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * WSUnitDTO dto1 = new WSUnitDTO();
	 * dto1.setRelationByALL("1000::grams#5# ->1::Kg#4#");
	 * 
	 * WSUnitDTO dto2 = new WSUnitDTO();
	 * dto2.setRelationByALL("2::Pau#7# ->2::HalfKg#6# ->1::Kg#4#");
	 * 
	 * List test= new ArrayList(); test.add(dto1); test.add(dto2);
	 * 
	 * WSUnitServiceImpl impl= new WSUnitServiceImpl(); Map
	 * test12=impl.getAllUnitRelationMap(test,"#4#"); WSUnitDTO
	 * unitDTO=(WSUnitDTO)test12.get(6); WSUnitDTO unitDTO1=(WSUnitDTO)
	 * test12.get(7);
	 * 
	 * System.out.println("item 1 is equal to "+unitDTO.getTwoUnitsRelator()+
	 * " * 3");
	 * System.out.println("item 2 is equal to "+unitDTO1.getTwoUnitsRelator
	 * ()+" * 12");
	 * 
	 * }
	 */

}
