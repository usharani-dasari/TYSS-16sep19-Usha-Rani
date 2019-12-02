package com.tyss.springmvcassessment.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	@Id
	@Column
	private int orderid;
	@Column
	private String productname;
	@Column
	private double priceperunit;
	@Column
	private int quantity;
	@Column
	private double amountpayable;
	@Column
	private int retailerid;
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPriceperunit() {
		return priceperunit;
	}
	public void setPriceperunit(double priceperunit) {
		this.priceperunit = priceperunit;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmountpayable() {
		return amountpayable;
	}
	public void setAmountpayable(double amountpayable) {
		this.amountpayable = amountpayable;
	}
	public int getRetailerid() {
		return retailerid;
	}
	public void setRetailerid(int retailerid) {
		this.retailerid = retailerid;
	}
	
	

}
