package com.cakefactory.product;

import java.util.List;

import com.cakefactory.category.Category;




public interface ProductService {
	public void insert(Product p);
	public void update(Product p);
	public void delete(int pid);
	public Product getProduct(int cid);
	public List<Product> ListProducts();

	public Product getProductWithMaxId();
	
}
