package com.barath.app.model;

import javax.persistence.Embeddable;

@Embeddable
public class RatingPK {
	
	private Long restaurantId;
	
	private Long userId;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public RatingPK(Long restaurantId, Long userId) {
		super();
		this.restaurantId = restaurantId;
		this.userId = userId;
	}
	
	

}
