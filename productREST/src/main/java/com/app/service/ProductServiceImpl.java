package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Product;
import com.app.exception.ProductExc;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodrepo;
	
	@Override
	public List<Product> getAllProducts() {
		
		return prodrepo.findAll();
	}

	@Override
	public Product addproduct(Product prod) {
		return prodrepo.save(prod);
	}

	@Override
	public Product getbyid(Long id) {		
		return prodrepo.findById(id)
				.orElseThrow(()->new ProductExc("Invalid product Id!!"));
	}
	

}
