package com.jwt.api.dto;

public class Item {

    private int itemId;
    private String name;
    private int qty;
    private double price;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Item(int itemId, String name, int qty, double price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
    
	public Item() {
	}
    
}
