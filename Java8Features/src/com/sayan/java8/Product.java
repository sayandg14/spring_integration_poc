/**
 * 
 */
package com.sayan.java8;

/**
 * @author user
 *
 */
public class Product {

	int productId;
	String productName;
	float price;
	
	public Product(int productId, String productName, float productLineNumber) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = productLineNumber;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductLineNumber() {
		return price;
	}
	public void setProductLineNumber(float productLineNumber) {
		this.price = productLineNumber;
	}
	
	
}
