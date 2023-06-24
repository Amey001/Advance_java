package com.app.service;

import java.util.List;

import com.app.entities.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	
	//add a new product 
	Product addproduct(Product prod);
	
	Product getbyid(Long id);
}
