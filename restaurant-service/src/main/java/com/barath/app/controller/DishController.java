package com.barath.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barath.app.service.DishService;

@RestController
public class DishController {
	
	private final DishService dishService;
	
		
	public DishController(DishService dishService) {
		super();
		this.dishService = dishService;
	}

	@GetMapping(value="/restaurant/{restaurantId}/dishes")
	public ResponseEntity<Object> getDishesGroupedBy(@PathVariable("restaurantId") Long resId, @RequestParam(value="type",required=false) String type){
		
		Assert.notNull(resId,"restaurant id cannot be null");
		if(StringUtils.isEmpty(type)) {
			return ResponseEntity.ok().body(this.dishService.getDishesByRestaurant(resId));
		}
		return ResponseEntity.ok().body(this.dishService.orderByDishes(resId));
		 	
	}
	
	@GetMapping(value="/restaurant/{restaurantId}/dishes/group")
	public ResponseEntity<Object> getDishesGroupedBy(@PathVariable("restaurantId") Long resId){
		
		Assert.notNull(resId,"restaurant id cannot be null");		
		return ResponseEntity.ok().body(this.dishService.orderByDishes(resId));
		 	
	}

}
