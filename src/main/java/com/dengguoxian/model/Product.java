package com.dengguoxian.model;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID=1234151L;
	private String name;
	private String description;
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	private float price;
	public Product(String name, String description, float price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Product() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
