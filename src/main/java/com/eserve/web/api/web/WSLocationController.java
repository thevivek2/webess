/**
 * WSLocationController.java
 * Vivek Adhikari
 * May 14, 2013
 */
package com.eserve.web.api.web;

import javax.faces.event.ActionEvent;

import com.eserve.web.api.core.WSBaseController;

/**
 * @author Vivek Adhikari
 *
 */
public interface WSLocationController extends WSBaseController {
	
	public void addLocation(ActionEvent event);

}
