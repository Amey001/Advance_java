package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Category;
import com.app.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
//	List<Product> findByCat(Category cat);
	List<Product> findByCat(Category cate);
	
}
