package com.product.service;

import java.util.List;

import com.product.dao.ProductDAO;
import com.product.dao.ProductDAOImplementation;
import com.product.model.Product;

public class ProductServiceImplementation implements ProductService {

	@Override
	public String getAllProducts(boolean onlyNewProducts) {
		System.out.println("ProductServiceImplementation : onlyNewProducts : " + onlyNewProducts );
		String jsonProductsList = "";
		
		ProductDAO productDAO= new ProductDAOImplementation();
		List<Product> productsList = productDAO.getAllProducts(onlyNewProducts);
		
		jsonProductsList = JsonUtil.convertObjectToJSON(productsList);
		
		return jsonProductsList;
	}

}
