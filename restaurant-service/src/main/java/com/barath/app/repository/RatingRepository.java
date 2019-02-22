package com.barath.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.app.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
