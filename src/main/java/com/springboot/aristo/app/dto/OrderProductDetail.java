package com.springboot.aristo.app.dto;

public interface OrderProductDetail {

	
	public long getOrder_no(); 
	public String getOrder_date();
	public String getName(); 
	public int getQty(); 
	public double getMrp(); 
	public double getPrice();
	public double getAmount();
	
	

}
