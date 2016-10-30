package com.cakefactory.product;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO {

public void insert(Product p);
public void update(Product p);
public void delete(int pid);
public Product getProduct(int pid);
public List<Product> ListProducts();

public Product getProductWithMaxId();
}
