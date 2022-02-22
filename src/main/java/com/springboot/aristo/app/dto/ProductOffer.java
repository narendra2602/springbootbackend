package com.springboot.aristo.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="productoffer")
public class ProductOffer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String category_name;
	private String name;
	private String description;
	private double price;
	private double mrp;
	private String image;
	private String scheme;
	private String validity;
	
	
	
}
