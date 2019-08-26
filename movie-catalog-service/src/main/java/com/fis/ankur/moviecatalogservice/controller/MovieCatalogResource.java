package com.fis.ankur.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fis.ankur.moviecatalogservice.pojoobject.CatalogItem;
import com.fis.ankur.moviecatalogservice.pojoobject.UserRating;
import com.fis.ankur.moviecatalogservice.service.MovieInfo;
import com.fis.ankur.moviecatalogservice.service.UserRatingInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;

	@RequestMapping("/{userId}")
	
	public List<CatalogItem> getcatalog(@PathVariable String userId) {
		// WebClient webClient = WebClient.builder();
		// List<Rating> ratings = Arrays.asList(new Rating("1234", "4"), new
		// Rating("5678", "3"));
		UserRating ratings = userRatingInfo.getUserRating(userId);
		return ratings.getUserRating().stream().map(rating -> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
		// return Collections.singletonList(new CatalogItem("DDLG","Test","4"));
	}

	public List<CatalogItem> getFallbackCatalog(@PathVariable String userId) {
		return Arrays.asList(new CatalogItem("No Movie Available", "", ""));
	}
}
