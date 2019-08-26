package com.fis.ankur.ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ankur.ratingdataservice.pojoobject.Rating;
import com.fis.ankur.ratingdataservice.pojoobject.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingDataResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId, "1");
	}

	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("1234","9"),new Rating("5678","8"));
		UserRating userating = new UserRating();
		userating.setUserRating(ratings);
		return userating;
	}
}
