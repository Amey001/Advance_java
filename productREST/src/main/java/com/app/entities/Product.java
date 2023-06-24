package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product extends BaseEntity {
	@Column(length = 20)
	private String name;
	
	private int quantity;
	private double price;
	@Column(length = 30)
	private String description;
	

	public Product() {
	
	}
	public Product(String name, int quantity, double price, String description) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + ", price=" + price + ", description=" + description
				+ "]";
	}
	
	
	

}
