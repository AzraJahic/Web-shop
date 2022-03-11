package com.product.service;

import java.util.List;

import com.product.dao.CouponDAO;
import com.product.dao.CouponDAOImplementation;
import com.product.model.Coupon;

public class CouponServiceImplementation implements CouponService{

	@Override
	public String getAllCoupons() {
		String jsonString = "";
		
		CouponDAO couponDAO = new CouponDAOImplementation();
		List<Coupon> allCoupons = couponDAO.getAllCoupons();
		jsonString = JsonUtil.convertObjectToJSON(allCoupons);
		
		return jsonString;
	}

}
