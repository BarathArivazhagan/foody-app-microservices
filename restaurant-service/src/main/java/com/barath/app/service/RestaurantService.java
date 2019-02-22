package com.barath.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.barath.app.model.Restaurant;
import com.barath.app.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	private final RestaurantRepository restaurantRepository;	
	
	
	public RestaurantService(RestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

	public List<Restaurant> getRestaurants(){
		return this.restaurantRepository.findAll();
	}
	
	public Restaurant saveRestaurant(Restaurant res){
		return this.restaurantRepository.save(res);
	}
	
	public List<Restaurant> getRestaurantByName(String resName){
		return this.restaurantRepository.findByRestaurantNameContainingIgnoreCase(resName);
	}
	
	public Optional<Restaurant> getRestaurantById(Long resId){
		return this.restaurantRepository.findById(resId);
	}
	
	
	@PostConstruct
	public void init() {
		
		Arrays.asList(new Restaurant(1L, "RESTARUANT1","BANGALORE"),
				new Restaurant(2L, "RESTARUANT2","CHENNAI"),
				new Restaurant(3L, "RESTARUANT3","BANGALORE"))
			.stream()
				.forEach(this::saveRestaurant);
	}

}
