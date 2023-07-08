package com.app.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Dto.Apiresponse;
import com.app.Dto.CatDto;
import com.app.Exception.ResourceNotFound;
import com.app.Repository.ProductRepository;
import com.app.entities.Category;
import com.app.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements productService{

	@Autowired
	private ProductRepository produrepo;
	
	@Override
	public Apiresponse addnewProduct(Product product) {
		String mesg="product not added !";
		
		Product product1=produrepo.save(product);
		System.out.println(product);
		if(product1!=null)
		{
			mesg="product inserted succesfully !!";
			return new Apiresponse(mesg);
		}
		return new Apiresponse(mesg);
	}

	@Override
	public List<Product> getlist() {
		
		return produrepo.findAll();
	}

	@Override
	public Apiresponse updateProduct(Product product) {
		
		String mesg="updating failed !!";
		Product prod=produrepo.save(product);
		if(prod!=null)
		{
			mesg="updated Successfully !!!";
			return new Apiresponse(mesg);
		}
		
		return new Apiresponse(mesg);
		
		
	}

	@Override
	public Apiresponse delete(Long id) {
		String mesg="cannot deleted product";
		if(produrepo.existsById(id))
		{
			produrepo.deleteById(id);
			mesg="deleted Successfully !!!";
			return new Apiresponse(mesg);
		}
		return new Apiresponse(mesg);
	}

//	@Override
//	public List<Product> getProduct(CatDto cat) {
//		
//		return produrepo.findByCat(cat.getCat());
//		
//	}

	

	@Override
	public List<Product> getProductByCat(Category cat) {
		
		return produrepo.findByCat(cat);
	}

	

	
}
