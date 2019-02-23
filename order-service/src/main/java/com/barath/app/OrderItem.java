package com.barath.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderItem {

	@Id
	@GeneratedValue
	private Long itemId;
	
	@Column
	private String itemName;
	
	@Column
	private int quantity;
	
	@Column
	private double price;
	

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public OrderItem(Long itemId, String itemName, int quantity, double price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItem(Long itemId) {
		super();
		this.itemId = itemId;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

}
