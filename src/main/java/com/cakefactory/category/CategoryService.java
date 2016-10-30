package com.cakefactory.category;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cakefactory.product.Product;
@Repository
public interface CategoryService {
	public void insert(Category c);
	public void update(Category c);
	public void delete(int cid);
	public Category getCategory(int cid);
	public List<Category> ListCategory();
	public Category getCategoryWithMaxId();
}
