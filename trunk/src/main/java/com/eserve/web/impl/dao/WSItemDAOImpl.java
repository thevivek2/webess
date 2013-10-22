/**
 * WSItemDAOImpl.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.impl.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.eserve.web.api.dao.WSItemDAO;
import com.eserve.web.api.service.WSSalesService;
import com.eserve.web.api.service.WSStockManageService;
import com.eserve.web.api.core.WSDTO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSItemDTO;
import com.eserve.web.impl.dto.WSSalesDTO;

/**
 * @author Vivek Adhikari
 * @param <WSDTO>
 * 
 */
@Named("wsItemDAO")
public class WSItemDAOImpl extends WSCommonDAO implements WSItemDAO,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8995732576135001695L;

	@Inject
	@Named("wsSalesService")
	WSSalesService salesService;
	
	@Inject
	@Named("wsStockManageService")
	WSStockManageService manageService;

	@Override
	public List<WSDTO> getModels(WSDTO model) {
		List<WSDTO> listModels = new ArrayList<WSDTO>();
		
		if(model instanceof WSSalesDTO)
		{
			RowMapper<WSItemDTO> rowMapper = new RowMapper<WSItemDTO>() {

				@Override
				public WSItemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
					WSItemDTO dto = new WSItemDTO();
					dto.setItemID(rs.getInt("itemid"));
					dto.setItemName(rs.getString("name"));
					dto.setItemCode(rs.getString("code"));
					return dto;
				}
			};

			List list = getJdbcTemplate().query(
					"select distinct a.itemid, b.name, b.des, b.code from Eserve_WAM_items b join eserve_wam_currentStock a on a.itemid=b.itemid  ",
					rowMapper);
			if (list != null && list.size() > 0) {
				listModels = list;

			}
			return listModels;
		}

		RowMapper<WSItemDTO> rowMapper = new RowMapper<WSItemDTO>() {

			@Override
			public WSItemDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				WSItemDTO dto = new WSItemDTO();
				dto.setItemID(rs.getInt("itemid"));
				dto.setItemName(rs.getString("name"));
				dto.setItemCode(rs.getString("code"));
				return dto;
			}
		};

		List list = getJdbcTemplate().query(
				"Select itemid, name, des, code from Eserve_WAM_items ",
				rowMapper);
		if (list != null && list.size() > 0) {
			listModels = list;

		}
		return listModels;
	}

	
	@Override
	public WSDTO getModel(WSDTO model) {

		if (model instanceof WSItemDTO) {
			WSItemDTO dto = (WSItemDTO) model;
			System.out.println("item id" + ((WSItemDTO) model).getItemID());
			System.out.println("unit id"
					+ ((WSItemDTO) model).getUnitDTO().getUnitID());
			Float test = getJdbcTemplate()
					.queryForObject(
							"select max(markedprice) from Eserve_WAM_StockIn where itemid = ? and unit = ?",
							new Object[] {
									((WSItemDTO) model).getItemID(),
									((WSItemDTO) model).getUnitDTO()
											.getUnitID() }, Float.class);
			dto.setMarkedPrice(new BigDecimal(test));
			return dto;
		}

		
		return null;

	}

	@Override
	public boolean saveModel(final WSDTO model) {
		if (model instanceof WSItemDTO) {

			boolean isNewItem = false;
			System.out.println("itemID is>>>>"
					+ ((WSItemDTO) model).getItemID());

			if (((WSItemDTO) model).getItemID() == 0) {
				isNewItem = true;
				System.out.println("user want to add new items");
				final String sql = "INSERT INTO Eserve_WAM_Items (name, code, alias, des, groupID, costingType, createdby, createdon) "
						+ "VALUES(?,?,?,?,?,?,?,?)";

				KeyHolder keyHolder = new GeneratedKeyHolder();
				getJdbcTemplate().update(new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(
							Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(sql,
								new String[] { "itemID" });
						ps.setString(1, ((WSItemDTO) model).getItemName());
						ps.setString(2, ((WSItemDTO) model).getItemCode());
						ps.setString(3, ((WSItemDTO) model).getItemAlias());
						ps.setString(4, ((WSItemDTO) model).getDes());
						ps.setInt(5, ((WSItemDTO) model).getStockGroupDTO()
								.getGroupID());
						ps.setLong(6, ((WSItemDTO) model).getCostingType());
						ps.setInt(7, 40125);
						ps.setTimestamp(8, new java.sql.Timestamp(
								new java.util.Date().getTime()));

						return ps;
					}
				}, keyHolder);

				((WSItemDTO) model).setItemID((Integer) keyHolder.getKey()
						.intValue());
				System.out.println("Genereted Key" + keyHolder.getKey());

			}

			getJdbcTemplate()
					.update("insert into Eserve_WAM_StockIn (itemid,billedQuantity,actualquantity, hasImpactOnStock,"
							+ " markedPriceUnit, markedprice, Unit,unitprice, totalprice,vendor,dutyfee,stockInON,createdby) "
							+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)",
							new Object[] {
									((WSItemDTO) model).getItemID(),
									((WSItemDTO) model).getQuantity(),
									((WSItemDTO) model).getQuantity(),
									((WSItemDTO) model).isHasImpactOnStock() ? 1
											: 0,
									((WSItemDTO) model).getUnitDTO()
											.getMarkedPriceUnitID(),
									((WSItemDTO) model).getMarkedPrice(),
									((WSItemDTO) model).getUnitDTO()
											.getUnitID(),
									((WSItemDTO) model).getUnitPrice(),
									((WSItemDTO) model).getTotalPrice(),
									((WSItemDTO) model).getVendor(),
									((WSItemDTO) model).getDutyFee(),
									new java.sql.Timestamp(new java.util.Date()
											.getTime()), 40125 });

			getJdbcTemplate()
					.update("insert into Eserve_WAM_currentStock (itemid,quantity, hasImpactOnStock,"
							+ " markedPriceUnit, markedprice, Unitid,unitprice, totalprice,vendor,dutyfee,stockOn,createdby) "
							+ "values (?,?,?,?,?,?,?,?,?,?,?,?)",
							new Object[] {
									((WSItemDTO) model).getItemID(),
									((WSItemDTO) model).getQuantity(),
									((WSItemDTO) model).isHasImpactOnStock() ? 1
											: 0,
									((WSItemDTO) model).getUnitDTO()
											.getMarkedPriceUnitID(),
									((WSItemDTO) model).getMarkedPrice(),
									((WSItemDTO) model).getUnitDTO()
											.getUnitID(),
									((WSItemDTO) model).getUnitPrice(),
									((WSItemDTO) model).getTotalPrice(),
									((WSItemDTO) model).getVendor(),
									((WSItemDTO) model).getDutyFee(),
									new java.sql.Timestamp(new java.util.Date()
											.getTime()), 40125 });

			if (isNewItem) {
				((WSItemDTO) model).setItemID(0);
			}

		}

		else if (model instanceof WSSalesDTO) {
			WSSalesDTO salesDTO = (WSSalesDTO) model;
			Iterator itr = salesDTO.getItemDTOs().iterator();
			while (itr.hasNext()) {
				WSItemDTO itemDTO = (WSItemDTO) itr.next();
				WSSalesDTO salesDTO2 = new WSSalesDTO();
				salesDTO2.setItemDTO(itemDTO);
				if (manageService.updateModel(salesDTO2)) {
					System.out.println("Current Stock has been updated");
				}

				getJdbcTemplate()
						.update("Insert into Eserve_WAM_StockOut(itemid,unitid, quantity, rate, totalPrice, vat, tax, discount, actualtotalprice, stockouton, createdby)"
								+ "values (?,?,?,?,?,?,?,?,?,?,?)" + "",
								new Object[] {
										itemDTO.getItemID(),
										itemDTO.getUnitDTO().getUnitID(),
										itemDTO.getQuantity(),
										itemDTO.getMarkedPrice(),
										itemDTO.getTotalPrice(),
										itemDTO.getTax(),
										itemDTO.getTax(),
										itemDTO.getDiscount(),
										itemDTO.getTotalPrice(),
										new java.sql.Timestamp(
												new java.util.Date().getTime()),
										40125

								});
			}

			getJdbcTemplate()
					.update("insert into Eserve_WAM_StockOut_Summary (totalprice, vat, tax, discount, actualtotalprice, stockouton, createdby) "
							+ "values (?,?,?,?,?,?,?)",
							new Object[] {
									salesDTO.getTotalSalePrice(),
									salesDTO.getTax(),
									salesDTO.getTax(),
									salesDTO.getDiscount(),
									salesDTO.getGrandTotalSalePrice(),
									new java.sql.Timestamp(new java.util.Date()
											.getTime()), 40125

							});

		}

		return true;
	}

	
}
