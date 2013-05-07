/**
 * @class:  WSLogDAOImpl.java
 * @author: Vivek Adhikari
 * @since:  Apr 8, 2013
 * 
 */
package com.eserve.web.impl.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import javax.inject.Named;





import com.eserve.web.api.core.WSDTO;
import com.eserve.web.api.dao.WSLogDAO;
import com.eserve.web.impl.common.WSCommonDAO;
import com.eserve.web.impl.dto.WSLogDTO;
import com.eserve.web.impl.dto.WSLogDTO.Status;

/**
 * @author Vivek Adhikari
 * @since Apr 8, 2013
 */

@Named("wsLogDAO")
public class WSLogDAOImpl extends WSCommonDAO implements WSLogDAO {
	
	/* (non-Javadoc)
	 * @see com.eserve.web.impl.common.WSCommonDAO#getModels(com.eserve.web.api.core.WSDTO)
	 */
	
	public List<WSDTO> getModels() {
		
			List<WSDTO> allLogs= new ArrayList<WSDTO>();
		
			WSLogDTO wsLogDTO = new WSLogDTO();
			wsLogDTO.setLogID(1);
			wsLogDTO.setLogDesc("Initial project setup , web.xml, faces-config.xml, application-context, pom.xml setup");
			wsLogDTO.setLogDate(getDate("2013/04/13"));
			wsLogDTO.setStatus(Status.Completed);
			wsLogDTO.setLoggedBy("Vivek Adhikari");
			allLogs.add(wsLogDTO);
			
			WSLogDTO wsLogDTO2 = new WSLogDTO();
			wsLogDTO2.setLogID(3);
			wsLogDTO2.setLogDesc("project package, class hierachy is prepared");
			wsLogDTO2.setLogDate(getDate("2013/04/18"));
			wsLogDTO2.setStatus(Status.Completed);
			wsLogDTO2.setLoggedBy("Vivek Adhikari");
			allLogs.add(wsLogDTO2);
			
			WSLogDTO wsLogDTO1 = new WSLogDTO();
			wsLogDTO1.setLogID(2);
			wsLogDTO1.setLogDesc("Initial Project header, leftpanal, content and footer Layout prepared");
			wsLogDTO1.setLogDate(getDate("2013/04/15"));
			wsLogDTO1.setStatus(Status.Completed);
			wsLogDTO1.setLoggedBy("Vivek Adhikari");
			allLogs.add(wsLogDTO1);
			
			WSLogDTO wsLogDTO5 = new WSLogDTO();
			wsLogDTO5.setLogID(4);
			wsLogDTO5.setLogDesc("Rich panel menu prepared");
			wsLogDTO5.setLogDate(getDate("2013/04/23"));
			wsLogDTO5.setStatus(Status.Completed);
			wsLogDTO5.setLoggedBy("Vivek Adhikari");
			allLogs.add(wsLogDTO5);
			
			
			WSLogDTO wsLogDTO6 = new WSLogDTO();
			wsLogDTO6.setLogID(6);
			wsLogDTO6.setLogDesc("Ajax based Application layout and setup. Rich faces Ajax form submit will be used mainly to show the content after the load");
			wsLogDTO6.setLogDate(getDate("2013/04/23"));
			wsLogDTO6.setStatus(Status.Inprogress);
			wsLogDTO6.setLoggedBy("Vivek Adhikari");
			allLogs.add(wsLogDTO6);
			
			
			WSLogDTO wsLogDTO7 = new WSLogDTO();
			wsLogDTO7.setLogID(7);
			wsLogDTO7.setLogDesc("This project's all forms will have ajax request and response ");
			wsLogDTO7.setLogDate(getDate("2013/04/23"));
			wsLogDTO7.setStatus(Status.Inprogress);
			wsLogDTO7.setLoggedBy("Vivek Adhikari");
			allLogs.add(wsLogDTO7);
			
			
			
			WSLogDTO wsLogDTO8 = new WSLogDTO();
			wsLogDTO8.setLogID(8);
			wsLogDTO8.setLogDesc("Basic layout, project setup completed , We can move to code on content now");
			wsLogDTO8.setLogDate(getDate("2013/04/29"));
			wsLogDTO8.setStatus(Status.Completed);
			wsLogDTO8.setLoggedBy("Vivek Adhikari");
			allLogs.add(wsLogDTO8);
			
			WSLogDTO wsLogDTO9 = new WSLogDTO();
			wsLogDTO9.setLogID(9);
			wsLogDTO9.setLogDesc("Domain prparation, Relation between domain's, Need to discuss  ");
			wsLogDTO9.setLogDate(getDate("2013/04/23"));
			wsLogDTO9.setStatus(Status.Stucked);
			wsLogDTO9.setLoggedBy("Vivek Adhikari");
			allLogs.add(wsLogDTO9);
			
	
		
		System.out.println("DAO retruning the rquest with DTO");
		return allLogs;
	}
	
	public Date getDate(String dateString)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	    java.util.Date utilDate = null;
	    try {
	      utilDate = formatter.parse(dateString);
	    } catch (ParseException e) {
	      
	      e.printStackTrace();
	    }
		
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

}
