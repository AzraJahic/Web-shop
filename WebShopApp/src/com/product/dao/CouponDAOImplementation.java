package com.product.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.product.model.Coupon;
import com.product.model.Product;

public class CouponDAOImplementation implements CouponDAO{

	private Connection conn;
	
	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub

		List<Coupon> allCoupons = new ArrayList<Coupon>();
		
		// Connection on DB 
		String query = "SELECT products.productName AS ProductName,"
				+ "	products.productPrice AS OldPrice,"
				+ "	coupon.discountPercentage AS Discount,"
				+ "	products.productPrice - ((products.productPrice * coupon.discountPercentage)/100) AS NewPrice "
				+ "FROM coupon "
				+ "INNER JOIN products ON products.idProduct = coupon.productId";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/web-shop", "hbstudent", "hbstudent");
			
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				
			//Back data from DB, format as Student model, save to allStudents Array List
				Coupon coupon = new Coupon();
				
				coupon.setProductName(rs.getString("ProductName"));
				coupon.setOldPrice(rs.getFloat("OldPrice"));
				coupon.setDiscount(rs.getInt("Discount"));
				coupon.setNewPrice(rs.getFloat("NewPrice"));
				
				allCoupons.add(coupon);
				
				System.out.println(coupon.toString());
			}
			
			return allCoupons;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem s uzimanjem podataka iz baze");
			e.printStackTrace();
		}
		
		return null;
	}

}
