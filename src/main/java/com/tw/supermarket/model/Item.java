package com.tw.supermarket.model;

public class Item {

	private int quantity;
	private SellingUnit sellingUnit;
	private Product product;

	public Item(int quantity, SellingUnit sellingUnit, Product product) {
		super();
		this.quantity = quantity;
		this.sellingUnit = sellingUnit;
		this.product = product;
	}
	
	public double getItemDiscountedPrice(){
		return this.getProduct().getDiscountedPrice(this.getQuantity());
	}
	

	public double getItemPrice() {
		return quantity*product.getPrice();
	}


	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public SellingUnit getSellingUnit() {
		return sellingUnit;
	}
	public void setSellingUnit(SellingUnit sellingUnit) {
		this.sellingUnit = sellingUnit;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
