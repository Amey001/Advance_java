package com.app.Service;

import java.util.List;

import com.app.Dto.Apiresponse;
import com.app.Dto.CatDto;
import com.app.entities.Category;
import com.app.entities.Product;

public interface productService {
	
	Apiresponse addnewProduct(Product product);
	List<Product> getlist();
	
	Apiresponse updateProduct(Product product);
	Apiresponse delete(Long id);
	
	
//	List<Product> getProduct(CatDto cat);
	List<Product> getProductByCat(Category cat);
	
}
