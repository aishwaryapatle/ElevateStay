package com.example.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.service.entities.Rating;
import com.example.user.service.entities.User;
import com.example.user.service.exceptions.ResourceNotFoundException;
import com.example.user.service.repositories.UserRepository;
import com.example.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	//get single user
	@Override
	public User getUser(String userId) {
		
		//get user from database with the help of user repository
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server!! : "+userId));
		
		//fetch rating of the above user from RATING SERVICE
		//http://localhost:8083/ratings/users/c0ad7b06-11c0-45f7-9f20-fe0df2ead6a9
		
//		ArrayList forObject = restTemplate.getForObject("http://localhost:8083/ratings/users/c0ad7b06-11c0-45f7-9f20-fe0df2ead6a9", ArrayList.class);
//		logger.info("{} ", forObject);
		
		Rating[] ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{} ",ratingsOfUser);
		
		List<Rating> ratings = Arrays.asList(ratingsOfUser);
		user.setRatings(ratings);
		
		return user;
	}

}