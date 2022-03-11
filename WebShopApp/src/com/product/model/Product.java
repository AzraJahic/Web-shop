package com.product.model;

import java.io.Serializable;

public class Product implements Serializable{
	private int idProduct;
	private String productName;
	private String productDescribe;
	private float productPrice;
	private int isNew;
	
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", productName=" + productName + ", productDescribe="
				+ productDescribe + ", productPrice=" + productPrice + ", isNew=" + isNew + "]";
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescribe() {
		return productDescribe;
	}
	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getIsNew() {
		return isNew;
	}
	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}
}
