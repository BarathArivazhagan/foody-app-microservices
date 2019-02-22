package com.barath.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown=true)
public class Rating implements Serializable{
	
	private static final long serialVersionUID = -8565537214870639567L;
	
	@Id
	private Long restaurantId;
	
	@Column
	private String restaurantName;
	
	@Column
	private Long userId;
	
	@Column
	private int rating;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Rating(Long restaurantId, int rating) {
		super();
		this.restaurantId = restaurantId;
		this.rating = rating;
	}

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	

	public Rating(Long restaurantId, Long userId, int rating) {
		super();
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.rating = rating;
	}

	public Rating(Long restaurantId, String restaurantName, Long userId, int rating) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.userId = userId;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", userId=" + userId
				+ ", rating=" + rating + "]";
	}



	

}
