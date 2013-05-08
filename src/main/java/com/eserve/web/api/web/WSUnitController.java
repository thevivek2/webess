/**
 * WSUnitController.java
 * Vivek Adhikari
 * May 8, 2013
 */
package com.eserve.web.api.web;

import javax.faces.event.ActionEvent;

import com.eserve.web.api.core.WSBaseController;
import com.eserve.web.impl.dto.WSUnitDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSUnitController extends WSBaseController {

	public WSUnitDTO getModel();

	/**
	 * @param event
	 */
	void addUnit(ActionEvent event);
}
