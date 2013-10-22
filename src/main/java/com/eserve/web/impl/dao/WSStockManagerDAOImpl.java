/**
 * WSStockManagerDAOImpl.java
 * Vivek Adhikari
 * Jun 7, 2013
 */
package com.eserve.web.impl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSStockManageDAO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSCurrentStockDTO;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSSalesDTO;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 * 
 */
@Named("wsStockManageDAO")
public class WSStockManagerDAOImpl extends WSCommonDAO implements
		WSStockManageDAO {

	@Override
	public WSDTO getModel(WSDTO model) {
		if (model instanceof WSSalesDTO) {
			WSSalesDTO salesDTO = (WSSalesDTO) model;
			WSItemDTO itemDTO = salesDTO.getItemDTO();
			
			if(getJdbcTemplate()
						.queryForObject(
								"select count(currentStockid) "
										+ " as currentStockCount from Eserve_WAM_currentStock "
										+ "where itemid = ? and unitid= ? and quantity = ?",
								new Object[] { itemDTO.getItemID(),
										itemDTO.getUnitDTO().getUnitID(),
										itemDTO.getQuantity() }, Integer.class) >=1 )
			{
				salesDTO.setResult(true);
				salesDTO.setCaseUpdate(1);
				
			}
			else if (getJdbcTemplate()
					.queryForObject(
							"select count(currentStockid) "
									+ " as currentStockCount from Eserve_WAM_currentStock "
									+ "where itemid = ? and unitid= ? and quantity > ?",
							new Object[] { itemDTO.getItemID(),
									itemDTO.getUnitDTO().getUnitID(),
									itemDTO.getQuantity() }, Integer.class) >=1 )
			{
				salesDTO.setResult(true);
				salesDTO.setCaseUpdate(2);
			}
			
			else if(getJdbcTemplate()
					.queryForObject(
							"select a.quantity = ? from ( "
									+ "select sum(quantity) as quantity "
									+ " from Eserve_WAM_currentStock "
									+ "where itemid = ? and unitid= ? and quantity < ? ) a",
							new Object[] { itemDTO.getQuantity(),
									itemDTO.getItemID(),
									itemDTO.getUnitDTO().getUnitID(),
									itemDTO.getQuantity() }, Integer.class) >= 1 )
			{
				salesDTO.setResult(true);
				salesDTO.setCaseUpdate(3);
			}
			
			else if (getJdbcTemplate()
						.queryForObject(
								"select a.quantity > ? from ( "
										+ "select sum(quantity) as quantity "
										+ " from Eserve_WAM_currentStock "
										+ "where itemid = ? and unitid= ? and quantity < ? )a",
								new Object[] { itemDTO.getQuantity(),
										itemDTO.getItemID(),
										itemDTO.getUnitDTO().getUnitID(),
										itemDTO.getQuantity() }, Integer.class) >= 1)
			{
				salesDTO.setResult(true);
				List list = getModels("select currentStockID, itemid, quantity, unitid, unitPrice from eserve_wam_currentStock"
						+ "where itemid = "
						+ itemDTO.getItemID()
						+ " and unitid= "
						+ itemDTO.getUnitDTO().getUnitID()
						+ " and quantity < " + itemDTO.getQuantity() + "+");
				salesDTO.setCurrentStockDTOs(list);
				salesDTO.setCaseUpdate(4);
			}


			return salesDTO;
		}

		else if (model instanceof WSCurrentStockDTO) {
			WSCurrentStockDTO currentStockDTO = (WSCurrentStockDTO) model;

			RowMapper<WSCurrentStockDTO> rowMapper = new RowMapper<WSCurrentStockDTO>() {
				@Override
				public WSCurrentStockDTO mapRow(ResultSet rs, int arg1)
						throws SQLException {
					WSCurrentStockDTO dto = new WSCurrentStockDTO();
					WSItemDTO itemDTO = new WSItemDTO();
					WSUnitDTO unitDTO = new WSUnitDTO();
					itemDTO.setUnitDTO(unitDTO);
					dto.setItemDTO(itemDTO);

					dto.setCurrentStockID(rs.getInt("currentStockID"));
					dto.getItemDTO().setItemID(rs.getInt("itemid"));
					dto.getItemDTO().setItemName(rs.getString("itemname"));
					dto.getItemDTO().setQuantity(rs.getFloat("quantity"));
					dto.getItemDTO().getUnitDTO().setUnitName(rs.getString("unitName"));
					dto.getItemDTO().setUnitPrice(rs.getFloat("unitPrice"));
					dto.getItemDTO().setCreatedOn(rs.getDate("stockon"));
					return dto;
				}
			};
			
			String strSQL = ""
					+ "SELECT a.currentstockid, "
					+ "       a.itemid, "
					+ "       b.name AS itemname, "
					+ "       a.quantity, "
					+ "       c.name AS unitname, "
					+ "       a. unitprice, "
					+ "       a.stockon "
					+ "FROM   eserve_wam_currentstock a "
					+ "       JOIN eserve_wam_items b "
					+ "         ON a.itemid = b.itemid "
					+ "       JOIN eserve_wam_units c "
					+ "         ON a.unitid = c.unitid";

			List list = getJdbcTemplate()
					.query(strSQL,
							rowMapper);
			currentStockDTO.setCurrentStockDTOs(list);
			return currentStockDTO;

		}
		return null;

	}

	@Override
	public List<WSDTO> getModels(String criteria) {
		List<WSDTO> listModels = new ArrayList<WSDTO>();
		RowMapper<WSCurrentStockDTO> rowMapper = new RowMapper<WSCurrentStockDTO>() {
			@Override
			public WSCurrentStockDTO mapRow(ResultSet rs, int arg1)
					throws SQLException {
				WSCurrentStockDTO dto = new WSCurrentStockDTO();

				dto.setCurrentStockID(rs.getInt("currentStockID"));
				dto.getItemDTO().setItemID(rs.getInt("itemid"));
				dto.getItemDTO().setQuantity(rs.getFloat("quantity"));
				dto.getItemDTO().setUnitPrice(rs.getFloat("unitPrice"));
				dto.getItemDTO().getUnitDTO().setUnitID(rs.getInt("unitid"));
				return dto;
			}
		};

		List list = getJdbcTemplate().query(criteria, rowMapper);
		if (list != null && list.size() > 0) {
			listModels = list;

		}
		return listModels;

	}

	@Override
	public boolean updateModel(WSDTO model) {
		boolean result = false;

		if (model instanceof WSSalesDTO) {
			WSSalesDTO salesDTO = (WSSalesDTO) model;
			WSItemDTO itemDTO = salesDTO.getItemDTO();
			switch (salesDTO.getCaseUpdate()) {
			case 1:
				getJdbcTemplate()
						.update("delete from  Eserve_WAM_currentStock "
								+ " where itemid = ? and unitid= ? and quantity = ? ORDER BY stockOn LIMIT 1",
								new Object[] { itemDTO.getItemID(),
										itemDTO.getUnitDTO().getUnitID(),
										itemDTO.getQuantity() });
				result = true;
				break;

			case 2:
				getJdbcTemplate()
						.update("update Eserve_WAM_currentStock set quantity = quantity - ?, totalprice = totalprice - unitprice * ?"
								+ " where  "
								+ " itemid = ? and unitid= ? and quantity > ?  ORDER BY stockOn LIMIT 1",
								new Object[] { itemDTO.getQuantity(),
										itemDTO.getQuantity(),
										itemDTO.getItemID(),
										itemDTO.getUnitDTO().getUnitID(),
										itemDTO.getQuantity() });
				result = true;
				break;

			case 3:

				getJdbcTemplate()
						.update("delete from  Eserve_WAM_currentStock "
								+ "where itemid = ? and unitid= ? and quantity < ?",
								new Object[] { itemDTO.getItemID(),
										itemDTO.getUnitDTO().getUnitID(),
										itemDTO.getQuantity() });
				result = true;
				break;

			default:
				break;
			}
			;
		}

		return result;
	}
}
