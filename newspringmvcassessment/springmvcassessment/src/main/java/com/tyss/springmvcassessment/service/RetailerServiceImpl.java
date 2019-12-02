package com.tyss.springmvcassessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springmvcassessment.dao.RetailerDaoImpl;
import com.tyss.springmvcassessment.dto.Order;
import com.tyss.springmvcassessment.dto.Product;
import com.tyss.springmvcassessment.dto.RetailerBean;

@Service
public class RetailerServiceImpl implements RetailerService {
	
	@Autowired
	private RetailerDaoImpl dao;
	
	@Override
	public int createProfile(RetailerBean bean) {
		return dao.createProfile(bean);
	}@Override
	public Order getOrders(int id) {
		return dao.getOrders(id);
	}@Override
	public RetailerBean login(int id, String password) {
		
		return dao.login(id, password);
	}@Override
	public Product search(int pid) {
		return dao.search(pid);
	}@Override
	public double totalAmount() {
		return dao.totalAmount();
	}@Override
	public boolean updatePassword(int id, String password) {
		return dao.updatePassword(id, password);
	}
	@Override
	public boolean doOrder(int pid, int quantity, int retailerid) {
		return dao.doOrder(pid, quantity, retailerid);
	}
	

}
