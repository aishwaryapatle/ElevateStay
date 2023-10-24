package com.example.rating.service.services;

import java.util.List;

import com.example.rating.service.entities.Rating;

public interface RatingService {
	
	
	//create
	Rating create(Rating rating);
	
	
	//get all
	List<Rating> getRatings();
	
	
	//get all by userId
	List<Rating> getRatingBuUserId(String userId);
	
	
	//get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);

}
