/**
 * WSSalesController.java
 * Vivek Adhikari
 * May 27, 2013
 */
package com.eserve.web.api.web;

import javax.faces.event.ActionEvent;

import com.eserve.web.api.core.WSBaseController;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSSalesController extends WSBaseController {

	/**
	 * @param e
	 */
	public void saleItems(ActionEvent e);

}
