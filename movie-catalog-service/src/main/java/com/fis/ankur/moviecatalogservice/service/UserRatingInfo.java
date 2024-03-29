package com.fis.ankur.moviecatalogservice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fis.ankur.moviecatalogservice.pojoobject.Rating;
import com.fis.ankur.moviecatalogservice.pojoobject.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://rating-data-service/ratingdata/users/" + userId, UserRating.class);
	}

	public UserRating getFallbackUserRating(String userId) {
		UserRating userRating = new UserRating();
		userRating.setUserRating(Arrays.asList(new Rating("0","0")));
		return userRating;
	}
}
