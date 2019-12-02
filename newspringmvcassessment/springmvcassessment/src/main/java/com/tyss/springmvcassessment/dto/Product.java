package com.tyss.springmvcassessment.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	@Column
	private double priceperproduct;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Order> order;
	
	
//	public List<Order> getOrder() {
//		return order;
//	}
//	public void setOrder(List<Order> order) {
//		this.order = order;
//	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPriceperproduct() {
		return priceperproduct;
	}
	public void setPriceperproduct(double priceperproduct) {
		this.priceperproduct = priceperproduct;
	}
	
	
	
	

}
