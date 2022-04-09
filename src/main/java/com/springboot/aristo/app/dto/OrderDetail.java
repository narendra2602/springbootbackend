package com.springboot.aristo.app.dto;

public interface OrderDetail {

	public long getId();
	public String getOrder_date();
	public String getCf_code();
	public String getCf_name();
	public String getStk_code();
	public String getStk_name();
	public double getAmount();

}
