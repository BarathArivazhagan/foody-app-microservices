package com.barath.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barath.app.model.Restaurant;
import com.barath.app.service.RestaurantService;

@RestController
public class RestaurantController {
	
	private final RestaurantService restaurantService;	
	
	
	public RestaurantController(RestaurantService restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}
	
	@PostMapping(value="/restaurant")
	public Restaurant createRestaurant(@RequestBody Restaurant res) {
		return this.restaurantService.saveRestaurant(res);
	}
	
	
	
	@GetMapping(value="/restaurants/{name}")
	public ResponseEntity<Object> getRestaurants(@PathVariable String name){
		if(StringUtils.isEmpty(name)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No name provided");
		}
		return   ResponseEntity.ok().body(this.restaurantService.getRestaurantByName(name));
	}


	@GetMapping(value="/restaurants")
	public List<Restaurant> getRestaurants(){
		return  this.restaurantService.getRestaurants();
	}

}
