package com.tyss.springmvcassessment.service;

import com.tyss.springmvcassessment.dto.Order;
import com.tyss.springmvcassessment.dto.Product;
import com.tyss.springmvcassessment.dto.RetailerBean;

public interface RetailerService {
	
	public int createProfile(RetailerBean bean);
	public RetailerBean login(int id,String password);
	public Product search(int pid);
	public boolean updatePassword(int id,String password);
	public double totalAmount();
	public Order getOrders(int id);
	public boolean doOrder(Product p,int quantity,int retailerid);
	

}
