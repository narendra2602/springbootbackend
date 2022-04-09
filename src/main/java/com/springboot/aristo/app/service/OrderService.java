package com.springboot.aristo.app.service;

import java.util.List;

import com.springboot.aristo.app.dto.OrderDetail;
import com.springboot.aristo.app.dto.OrderFst;
import com.springboot.aristo.app.dto.OrderProductDetail;

public interface OrderService {

		OrderFst saveOrder(OrderFst order);
		OrderFst getOrderById(Long id);
		List<OrderDetail> getAllOrders();
		List<OrderDetail> getAllOrders(String stkid);
		List<OrderDetail> getAllCFOrders(String cfid);
		List<OrderProductDetail> getOrder(Long order_no);
	
}
