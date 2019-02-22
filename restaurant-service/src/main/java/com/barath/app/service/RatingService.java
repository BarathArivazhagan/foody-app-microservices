package com.barath.app.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.barath.app.model.Rating;
import com.barath.app.repository.RatingRepository;

@Service
public class RatingService {
	
	private final RatingRepository ratingRepository;

	public RatingService(RatingRepository ratingRepository) {
		super();
		this.ratingRepository = ratingRepository;
	}
	
	
	public Rating saveRating(Rating rating) {
		return this.ratingRepository.save(rating);
	}
	
	public List<Rating> getRatings(){
		return this.ratingRepository.findAll();
	}
	
	@PostConstruct
	public void init() {
		
		Arrays.asList(new Rating(1L, 1L,3))
			.stream().forEach(this::saveRating);
	}
	

}
