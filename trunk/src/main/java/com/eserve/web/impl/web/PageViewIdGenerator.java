package com.eserve.web.impl.web;


import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Vivek Adhikari
 */
@Controller
@Named("pageViewIdGenerator")
@Scope("request")
public class PageViewIdGenerator implements Serializable{

	private String projectHeadTitle = "WAM System - The Complete web based Accounting Soluction";
	private String includedPage = "/welcome.xhtml";
	
	private static final long serialVersionUID = -8942243432409952875L;

	public String getSideBarAction() {
		/**
		 * Get the request parameter map from the context, so that we can find
		 * which link of the side is clicked
		 */
		FacesContext context = FacesContext.getCurrentInstance();
		String selectedPageViewId = context.getExternalContext()
				.getRequestParameterMap().get("pageViewId");

		if (selectedPageViewId.equalsIgnoreCase("CreateStockGroup")) {
			includedPage = "CreateStockGroup";
		} else if (selectedPageViewId.equalsIgnoreCase("showAllLogs")) {
			includedPage = "showAllLogs";
		} else if (selectedPageViewId.equalsIgnoreCase("createItem")) {
			includedPage = "createItem";
		
		} else if (selectedPageViewId.equalsIgnoreCase("units")) {
			includedPage = "units";
			
		} else if (selectedPageViewId.equalsIgnoreCase("location")) {
			includedPage = "location";
		}
		return "";
	}

	/**
	 * @return the includedPage
	 */
	public String getIncludedPage() {
		return includedPage;
	}

	/**
	 * @param includedPage
	 *            the includedPage to set
	 */
	public void setIncludedPage(String includedPage) {
		this.includedPage = includedPage;
	}

	/**
	 * @return the projectHeadTitle
	 */
	public String getProjectHeadTitle() {
		return projectHeadTitle;
	}

	/**
	 * @param projectHeadTitle
	 *            the projectHeadTitle to set
	 */
	public void setProjectHeadTitle(String projectHeadTitle) {
		this.projectHeadTitle = projectHeadTitle;
	}

}