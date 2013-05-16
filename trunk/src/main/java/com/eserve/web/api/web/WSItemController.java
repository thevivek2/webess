/**
 * WSItemController.java
 * Vivek Adhikari
 * Apr 30, 2013
 */
package com.eserve.web.api.web;

import javax.faces.event.ActionEvent;

import com.eserve.web.api.core.WSBaseController;
import com.eserve.web.impl.dto.WSItemDTO;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSItemController extends WSBaseController {
	
	public void addItem(ActionEvent event);

	/**
	 * @return
	 */
	public WSItemDTO getModel();

}
