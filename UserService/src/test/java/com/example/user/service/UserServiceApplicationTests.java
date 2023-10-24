package com.example.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user.service.entities.Rating;
import com.example.user.service.extenal.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;
	
	@Test
	void createRating() {
		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("This is created using feign client").build();
		Rating savedRating = ratingService.createRating(rating);
		
		System.out.println("New Rating Created!");
	}
}
