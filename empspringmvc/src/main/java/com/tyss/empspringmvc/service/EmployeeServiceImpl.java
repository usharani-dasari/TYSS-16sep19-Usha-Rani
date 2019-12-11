package com.tyss.empspringmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.empspringmvc.dao.EmployeeDAO;
import com.tyss.empspringmvc.dto.EmployeeBean;


//@Component =>since it is a service layer,instead of @Component we can use @Service.
//both r one nd the same.As a standard use @Service
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO dao ;
	
	 @Override
	public boolean changePassword(int id, String password) {
		
		return dao.changePassword(id, password);
	}
	 
	 @Override
	public boolean deleteEmployee(int id) {
		
		return dao.deleteEmployee(id);
	}
	 
	 @Override
	public EmployeeBean login(int id, String password) {
		
		return dao.login(id, password);
	}
	 
	 @Override
	public int register(EmployeeBean bean) {
		//logic to check email and password(validation)
		return dao.register(bean);
	}
	 
	 @Override
	public EmployeeBean searchEmployee(int id) {
		
		return dao.searchEmployee(id);
	}
	 
	 @Override
	public boolean updateEmployee(EmployeeBean bean) {
		
		return dao.updateEmployee(bean);
	}

}
