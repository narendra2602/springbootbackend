package com.springboot.aristo.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.aristo.app.dao.OrderFstDao;
import com.springboot.aristo.app.dto.OrderDetail;
import com.springboot.aristo.app.dto.OrderFst;
import com.springboot.aristo.app.dto.OrderProductDetail;
import com.springboot.aristo.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderFstDao orderFstDao;
	
	@Override
	public OrderFst saveOrder(OrderFst order) {
		// TODO Auto-generated method stub
		return orderFstDao.save(order);
	}

	@Override
	public OrderFst getOrderById(Long id) {
		// TODO Auto-generated method stub
		Optional<OrderFst> ord = orderFstDao.findById(id);
		return ord.get();
	}

	@Override
	public List<OrderDetail> getAllOrders() {
		// TODO Auto-generated method stub
		//return orderFstDao.findAll();
		return orderFstDao.getOrderList("Admin","0");
	}

	@Override
	public List<OrderDetail> getAllOrders(String stkid) {
		// TODO Auto-generated method stub
		//return orderFstDao.findByStkCode(stkid);
		return orderFstDao.getOrderList("Stockiest",stkid);
	}

	@Override
	public List<OrderDetail> getAllCFOrders(String cfid) {
		// TODO Auto-generated method stub
		//return orderFstDao.findByCfCodeOrderByOrderDate(cfid);
		return orderFstDao.getOrderList("CF",cfid);
	}

	@Override
	public List<OrderProductDetail> getOrder(Long order_no) {
		// TODO Auto-generated method stub
		

		return orderFstDao.getOrder(order_no);
	}


}
