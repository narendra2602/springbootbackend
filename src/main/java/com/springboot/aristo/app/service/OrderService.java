package com.springboot.aristo.app.service;

import java.util.List;

import com.springboot.aristo.app.dto.OrderFst;
import com.springboot.aristo.app.dto.OrderProductDetail;

public interface OrderService {

		OrderFst saveOrder(OrderFst order);
		OrderFst getOrderById(Long id);
		List<OrderFst> getAllOrders();
		List<OrderFst> getAllOrders(String stkid);
		List<OrderFst> getAllCFOrders(String cfid);
		List<OrderProductDetail> getOrder(Long order_no);
	
}
