/**
 * @class:  WSCommonDAO.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.common;

import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import org.springframework.stereotype.Repository;

import com.eserve.web.api.core.WSDAO;
import com.eserve.web.api.core.WSDTO;


/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 * This class is responsible for database trasition operation
 */
@Repository
@Named("wsCommonDAO")
public class WSCommonDAO implements WSDAO {

	
	
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println(">>>> inside setDataSource");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDAO#getModel(java.lang.String)
	 */
	@Override
	public WSDTO getModel(String modelID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDAO#saveModel(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public boolean saveModel(WSDTO model) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDAO#getModels()
	 */
	@Override
	public List<WSDTO> getModels() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDAO#getModels(java.lang.String)
	 */
	@Override
	public List<WSDTO> getModels(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDAO#updateModel(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public boolean updateModel(WSDTO model) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDAO#getModels(com.eserve.web.api.core.WSDTO)
	 */
	@Override
	public List<WSDTO> getModels(WSDTO model) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDAO#updateModels(java.util.List)
	 */
	@Override
	public boolean updateModels(List<WSDTO> modelsList) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.eserve.web.api.core.WSDAO#getModelsForDropDown(java.util.List)
	 */
	@Override
	public List<SelectItem> getModelsForDropDown(List<WSDTO> modelsList) {
		// TODO Auto-generated method stub
		return null;
	}

}
