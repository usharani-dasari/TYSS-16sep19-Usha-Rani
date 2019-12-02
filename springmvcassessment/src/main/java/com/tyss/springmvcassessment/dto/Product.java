package com.tyss.springmvcassessment.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
