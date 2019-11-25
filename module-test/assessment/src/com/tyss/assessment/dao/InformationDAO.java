package com.tyss.assessment.dao;

import java.util.List;

import com.tyss.assessment.dto.InformationBean;

public interface InformationDAO {
	
	public List<String> getAllContactNames();
	public InformationBean searchForContact(String name);
	

}
