package com.springboot.aristo.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ordersnd")
public class OrderSnd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int pcode;
	private int qty;
	private double price;
	private double mrp;
	
	
/*	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name="order_id")
	@JsonIgnore
	private OrderFst order;
*/	
	
}
