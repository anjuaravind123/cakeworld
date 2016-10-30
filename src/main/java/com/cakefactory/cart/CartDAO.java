package com.cakefactory.cart;

import java.io.IOException;
import java.util.List;

import com.cakefactory.product.Product;

public interface CartDAO
{
	Cart getCartById(int cartId);
	
	Cart getCartByUsername(String Username);
	
	String checkUsername(String Username);

    void update(Cart cart);
    
    void add(Cart cart);
    
    void delete(int i);
    
    void deleteByProductId(int pid);
    
    public List<Cart> getAllItems();
}