package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Product;
import com.demo.service.ProductService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestfulProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping(path="/products",produces="application/json")
	public List<Product> getAllProduct() {
		List<Product> plist=productService.getAllProduct();
		System.out.println("length : " +plist.size());
		return plist;
		
	}	
			//reading DATA
		@GetMapping(path="/products/{id}",produces="application/json")
		public Product getProductById(@PathVariable("id")int id) {
			return productService.getProductById(id);
		}
		
			//add of data
		@PostMapping(path="/products",headers="Accept=application/json")
		public List<Product>addProduct(@RequestBody Product p) {
			productService.addProduct(p);
			List<Product> plist=productService.getAllProduct();
			return plist;
		}
		
			//update of data
		@PutMapping(path="/products",headers="Accept=application/json") 
		public List<Product> updateProduct(@RequestBody Product p)
		{
			productService.updateProduct(p);
			List<Product> plist=productService.getAllProduct();
			return plist;
				
		}
		
			//delete of data
		@DeleteMapping(path="products/{id}")
		public List<Product> deleteProduct(@PathVariable("id") int pid) {
			productService.deleteById(pid);
			List<Product> plist=productService.getAllProduct();
			return plist;
		}
		
		
		}
		
		
	
