package com.airbus.aerothon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbus.aerothon.entities.impl.NewsFeed;
import com.airbus.aerothon.services.NewsFeedService;

@RestController
@RequestMapping("/aerothon")
public class AerothonController {

	@Autowired
	NewsFeedService newsFeedService;
	
	@GetMapping("/news")
	public List<NewsFeed> getNewsFeeds() {
		return newsFeedService.getNewsFeeds();
	}
}
