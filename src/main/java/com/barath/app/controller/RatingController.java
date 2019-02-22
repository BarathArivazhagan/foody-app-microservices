package com.barath.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barath.app.model.Rating;
import com.barath.app.service.RatingService;

@RestController
public class RatingController {
	
	private final RatingService ratingService;
	
	
	public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}

	@PostMapping(value="/restaurant/rating")
	public ResponseEntity<Object> saveRestaurantRating(@RequestBody Rating rating) {
		
		if(rating!=null && rating.getUserId() !=null) {
			return ResponseEntity.ok().body(this.ratingService.saveRating(rating));
		}
		return ResponseEntity.badRequest().body("No user id provided");
	}
	

	
	@GetMapping(value="/restaurant/ratings")
	public List<Rating> getRestaurantRating() {		
		return this.ratingService.getRatings();
	}

}
