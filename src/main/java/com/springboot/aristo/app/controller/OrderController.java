package com.springboot.aristo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.aristo.app.dto.OrderFst;
import com.springboot.aristo.app.dto.OrderProductDetail;
import com.springboot.aristo.app.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/api/order")
public class OrderController {

		@Autowired
		private OrderService orderService;
		

		@PostMapping
		public ResponseEntity<OrderFst> saveorder(@RequestBody OrderFst order)
		{
/*		    OrderFst ord = new OrderFst();
		    ord.setCfCode(order.getCfCode());
		    ord.setFsCode(order.getFsCode());
		    ord.setOrderStatus(true);
		    ord.setStkCode(order.getStkCode());
		    ord.setOrderDate(new Date());
		    ord.setUserId(order.getUserId());
		    int size=order.getItems().size();
		    OrderSnd s=null;
		    
		    for(int i=0; i<size; i++ )
		    {
		    	 s = order.getItems().get(i);
		    	 s.setOrder(ord);
		    	 order.getItems().add(i, s);
		    }
*/		    
			return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
					
		}

		
	
		@GetMapping("{id}")
		public ResponseEntity<OrderFst> getOrder(@PathVariable("id") Long id)
		{

			return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
					
		}
		
		@GetMapping
		public ResponseEntity<List<OrderFst>> getAllOrders()
		{
			return new ResponseEntity<List<OrderFst>>(orderService.getAllOrders(), HttpStatus.OK);
			
		}
		
		@GetMapping("/stockiest/{stkid}")
		public ResponseEntity<List<OrderFst>> getAllOrdersStockiest(@PathVariable("stkid") String stkid)
		{
			return new ResponseEntity<List<OrderFst>>(orderService.getAllOrders(stkid), HttpStatus.OK);
			
		}

		@GetMapping("/cf/{cfid}")
		public ResponseEntity<List<OrderFst>> getAllOrdersCF(@PathVariable("cfid") String cfid)
		{
			return new ResponseEntity<List<OrderFst>>(orderService.getAllCFOrders(cfid), HttpStatus.OK);
			
		}

		
		@GetMapping("/orderdetail/{order_no}")
		public ResponseEntity<List<OrderProductDetail>> getOrderDetail(@PathVariable("order_no") Long order_no)
		{
			return new ResponseEntity<List<OrderProductDetail>>(orderService.getOrder(order_no), HttpStatus.OK);
			
		}

		
}

