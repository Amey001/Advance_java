package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.Dto.CatDto;
import com.app.Service.productService;
import com.app.entities.Category;
import com.app.entities.Product;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	@Autowired
	private productService service;
	
	@PostMapping
	public ResponseEntity<?> addnewProduct(@RequestBody Product product)
	{
		return new ResponseEntity<>(service.addnewProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Product> productlist()
	{
		return service.getlist();
	}
	
	@PutMapping
	public ResponseEntity<?> updateProduct(@RequestBody Product detached)
	{
		return new ResponseEntity<>(service.updateProduct(detached), HttpStatus.OK);
	}
	
//	@GetMapping("/cat")
//	public ResponseEntity<?> getProductdetails(@RequestBody CatDto cat)
//	{
//		
//		return new ResponseEntity<>(service.getProduct(cat), HttpStatus.OK);
//	}
//	
	@GetMapping("/{cate}")
	public List<Product> getProductlist(@PathVariable String cate)
	{
		Category cat=Category.valueOf(cate);
		return service.getProductByCat(cat);
	}
 	
//	@PostMapping("/{id}")
//	public ResponseEntity<?> updateProductonid(@RequestBody Long id)
//	{
//		return new ResponseEntity<T>(null,HttpStatus.OK);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletebyid(@PathVariable Long id)
	{
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
		
	}
 
}
