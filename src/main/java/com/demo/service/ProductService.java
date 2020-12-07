package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Product;

public interface ProductService {

	void addProduct(Product p);

	List<Product> getAllProduct();

	Product getProductById(int id);

	int updateProduct(Product p);

	int deleteById(int id);

}