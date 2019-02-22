package com.barath.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.app.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
		
	List<Restaurant> findByRestaurantName(String name);
	List<Restaurant> findByRestaurantNameContainingIgnoreCase(String name);
}
