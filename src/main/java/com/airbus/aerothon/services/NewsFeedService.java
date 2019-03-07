package com.airbus.aerothon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.aerothon.entities.impl.NewsFeed;
import com.airbus.aerothon.repository.impl.NewsRepository;
import com.google.common.collect.Lists;

@Service
public class NewsFeedService {
	
	@Autowired
	NewsRepository newsRepository;

	public List<NewsFeed> getNewsFeeds() {
		return Lists.newArrayList(newsRepository.findAll());
	}
	
	
}
