package com.springboot.aristo.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.aristo.app.dto.Product;
import com.springboot.aristo.app.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api/product")

public class ProductController {
	
	private ProductService productService;
	
	

	
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@PostMapping()
	public ResponseEntity<Product>  saveProduct(@RequestBody Product product)
	{
		System.out.println(product.toString());
		
		return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
	}

	
	
	

	@GetMapping()
	public List<Product> getAllProducts()
	{
		
		return productService.getAllProducts(); 
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}

	
	@PutMapping("{id}")
	public ResponseEntity<Product>  updateProduct(@RequestBody Product product, @PathVariable("id") int id)
	{
		
		return new ResponseEntity<Product>(productService.updateProduct(product,id),HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String>  deleteProduct( @PathVariable("id") int id)
	{
		
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Record Deleted sucessfully",HttpStatus.OK);
	}


	

}
