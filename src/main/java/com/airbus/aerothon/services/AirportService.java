package com.airbus.aerothon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.aerothon.entities.impl.Airport;
import com.airbus.aerothon.repository.impl.AirportRepository;
import com.google.common.collect.Lists;

@Service
public class AirportService {
	
	@Autowired
	AirportRepository airportRepository;

	public List<Airport> getAirports() {
		return Lists.newArrayList(airportRepository.findAll());
	}
	
	
}
