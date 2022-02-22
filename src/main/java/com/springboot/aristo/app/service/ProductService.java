package com.springboot.aristo.app.service;

import java.util.List;


import com.springboot.aristo.app.dto.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product getProductById(int id);
	Product saveProduct(Product product);
	Product updateProduct(Product product, int id);
	void deleteProduct(int id);

}
