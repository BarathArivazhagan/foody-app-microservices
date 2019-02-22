package com.barath.app.model;

import java.io.Serializable;

public class DishItem implements Serializable{
	
	private static final long serialVersionUID = -4698471850204276365L;

	private Long dishItemId;
	
	private String dishName;
	
	private String dishType;
	
	private double price;

	public Long getDishItemId() {
		return dishItemId;
	}

	public void setDishItemId(Long dishItemId) {
		this.dishItemId = dishItemId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DishItem(Long dishItemId, String dishName, String dishType, double price) {
		super();
		this.dishItemId = dishItemId;
		this.dishName = dishName;
		this.dishType = dishType;
		this.price = price;
	}

	public DishItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DishItem [dishItemId=" + dishItemId + ", dishName=" + dishName + ", dishType=" + dishType + ", price="
				+ price + "]";
	}
	
	

	
	

}
