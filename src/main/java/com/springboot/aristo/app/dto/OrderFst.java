package com.springboot.aristo.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orderfst")
public class OrderFst {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="order_date")
	private Date orderDate;
	
	private long userId;
	private String stkCode;
	private String cfCode;
	private String fsCode;
	private boolean orderStatus;
	
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="order_id", referencedColumnName="id")
	List<OrderSnd> items = new ArrayList<>();
	
	
}
