package com.product.dao;

import java.util.List;

import com.product.model.Product;

public interface ProductDAO {
	public List<Product>getAllProducts(boolean onlyNewProducts);

}
