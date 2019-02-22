package com.barath.app.model;

public class Dish {
	
	private Long restaurantId;
	
	public Dish(Long restaurantId, Long dishId) {
		super();
		this.restaurantId = restaurantId;
		this.dishId = dishId;
	}

	public Long getDishId() {
		return dishId;
	}

	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	private Long dishId;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	

	
	public Dish(Long restaurantId) {
		super();
		this.restaurantId = restaurantId;
		
	}

	public Dish() {
		super();
		
	}
	
	
	

}
