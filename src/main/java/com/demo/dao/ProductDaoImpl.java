package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.bean.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertProduct(Product p) {
		String sql="insert into product(pid,pname,price) values(?,?,?)";
		return  jdbcTemplate.update(sql,new Object[] {p.getPid(),p.getPname(),p.getPrice()});
		
	}

	@Override
	public List<Product> getAllData() {
		System.out.println("In doa getAll products");
		String sql="select pid,pname,price from product";
		List<Product> plist=(List<Product>)jdbcTemplate.query(sql, new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int num) throws SQLException {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				return p;
				
			}
     	});
		return plist;
	}

	@Override
	public Product getById(int id) {
		String sql="select * from product where pid=?";
		Product p=(Product)jdbcTemplate.queryForObject(sql, new Object[] {id},new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int num) throws SQLException {
				Product p=new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3));
				return p;
			}
			
		});
		return p;
	}

	@Override
	public int updateProduct(Product p) {
		String sql="update product set pname=?,price=? where pid=?";
		return jdbcTemplate.update(sql, new Object[] {p.getPname(),p.getPrice(),p.getPid()});
		
	}

	@Override
	public int deleteProductById(int id) {
		String sql="delete from product where pid=?";
		return jdbcTemplate.update(sql,new Object[] {id});
	
	}

}