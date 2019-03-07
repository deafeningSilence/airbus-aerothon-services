package com.airbus.aerothon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbus.aerothon.dto.in.FlightQueryRequestDTO;
import com.airbus.aerothon.entities.impl.Flight;
import com.airbus.aerothon.entities.impl.NewsFeed;
import com.airbus.aerothon.entities.impl.Program;
import com.airbus.aerothon.services.FlightService;
import com.airbus.aerothon.services.NewsFeedService;
import com.airbus.aerothon.services.ProgramService;

@RestController
@RequestMapping("/aerothon")
public class AerothonController {

	@Autowired
	NewsFeedService newsFeedService;

	@Autowired
	ProgramService programService;

	@Autowired
	FlightService flightService;

	// NEWS - INDEX
	@GetMapping("/news")
	public List<NewsFeed> getNewsFeeds() {
		return newsFeedService.getNewsFeeds();
	}

	// PROGRAM - INDEX
	@GetMapping("/program")
	public List<Program> getPrograms() {
		return programService.getPrograms();
	}

	// FLIGHT - INDEX
	@GetMapping("/flight")
	public List<Flight> getFlights(@RequestBody FlightQueryRequestDTO flightQueryRequestDTO) {
		return flightService.getFlights(flightQueryRequestDTO);
	}

	// FLIGHT - SHOW
	@GetMapping("/flight/{flightId}")
	public Flight getFlight(@PathVariable("flightId") Integer flightId) {
		return flightService.getFlight(flightId);
	}

	// FLIGHT - CREATE
	@PostMapping("/flight")
	public Flight addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

	// FLIGHT - UPDATE
	@PutMapping("/flight/{flightId}")
	public Flight updateFlight(@PathVariable("flightId") Integer flightId, @RequestBody Flight flight) {
		return flightService.updateFlight(flightId, flight);
	}
	
	// FLIGHT - DELETE
	@DeleteMapping("/flight/{flightId}")
	public Flight deleteFlight(@PathVariable("flightId") Integer flightId) {
		return flightService.deleteFlight(flightId);
	}
}
