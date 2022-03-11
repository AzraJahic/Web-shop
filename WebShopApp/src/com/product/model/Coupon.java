package com.product.model;

import java.io.Serializable;

public class Coupon implements Serializable{
	private String productName;
	private float oldPrice;
	private int discount;
	private float newPrice;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(float oldPrice) {
		this.oldPrice = oldPrice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public float getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(float newPrice) {
		this.newPrice = newPrice;
	}
	@Override
	public String toString() {
		return "Coupon [productName=" + productName + ", oldPrice=" + oldPrice + ", discount=" + discount
				+ ", newPrice=" + newPrice + "]";
	}
	
}
