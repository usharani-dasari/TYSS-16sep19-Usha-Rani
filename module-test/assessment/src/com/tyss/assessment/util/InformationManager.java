package com.tyss.assessment.util;

import com.tyss.assessment.dao.InformationDAO;
import com.tyss.assessment.dao.InformationDAOImpl;

public class InformationManager {
	private InformationManager() {}
	
	public static InformationDAO getInformationDAO(){
		return new InformationDAOImpl();
		
	}

}
