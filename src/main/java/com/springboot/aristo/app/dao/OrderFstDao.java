package com.springboot.aristo.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.aristo.app.dto.OrderFst;
import com.springboot.aristo.app.dto.OrderProductDetail;


public interface OrderFstDao extends JpaRepository<OrderFst, Long> {

	public OrderFst findById(long Id);
	public List<OrderFst> findByStkCode(String stkcode);
	

	public List<OrderFst> findByCfCodeOrderByOrderDate(String cfcode);
	
	@Query(value="CALL getOrder(:id_in);", nativeQuery=true)
	List<OrderProductDetail> getOrder(@Param("id_in") Long id) ;
	

	
}
