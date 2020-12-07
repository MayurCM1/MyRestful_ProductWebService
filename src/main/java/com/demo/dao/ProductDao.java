package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.demo.bean.Product;

public interface ProductDao {

	int insertProduct(Product p);

	List<Product> getAllData();

	Product getById(int id);

	int updateProduct(Product p);

	int deleteProductById(int id);

}