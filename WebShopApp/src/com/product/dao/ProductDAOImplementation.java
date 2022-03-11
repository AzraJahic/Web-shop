package com.product.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.product.model.Product;

public class ProductDAOImplementation implements ProductDAO{
	private Connection conn;

	@Override
	public List<Product> getAllProducts(boolean onlyNewProducts) {
		
		List<Product> allProducts = new ArrayList<Product>();
		
		// Connection on DB 
		String query = "SELECT * FROM products";
		System.out.println("ProductDAOImplementation : getAllProducts : only new products: " + onlyNewProducts);
		if(onlyNewProducts) {
			query += " WHERE isNew = 1";
		}
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/web-shop", "hbstudent", "hbstudent");
			System.out.println("Konektovan");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				
			//Back data from DB, format as Student model, save to allStudents Array List
				Product product = new Product();
				product.setIdProduct(rs.getInt("idProduct"));
				product.setProductName(rs.getString("productName"));
				product.setProductDescribe(rs.getString("productDescribe"));
				product.setProductPrice(rs.getFloat("productPrice"));
				product.setIsNew(rs.getInt("isNew"));
				
				allProducts.add(product);
				
				System.out.println(product.toString());
			}
			
			return allProducts;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem s uzimanjem podataka iz baze");
			e.printStackTrace();
		}
		
		return null;
	}

}
