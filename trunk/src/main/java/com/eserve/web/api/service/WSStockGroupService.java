package com.eserve.web.api.service;

import com.eserve.web.api.core.WSBaseService;
import com.eserve.web.impl.dto.WSStockGroupDTO;

import java.util.List;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSStockGroupService extends WSBaseService {

	public List<WSStockGroupDTO> getAllGroups();
}
