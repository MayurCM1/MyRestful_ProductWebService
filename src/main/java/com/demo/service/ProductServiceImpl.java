package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	public void addProduct(Product p) {
		productDao.insertProduct(p);
		
	}

	@Override
	public List<Product> getAllProduct() {
		System.out.println("in service getall products");
		return productDao.getAllData();
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getById(id);
	}

	@Override
	public int updateProduct(Product p) {
		return productDao.updateProduct(p);
		
	}

	@Override
	public int deleteById(int id) {
		return productDao.deleteProductById(id);
		
	}

}