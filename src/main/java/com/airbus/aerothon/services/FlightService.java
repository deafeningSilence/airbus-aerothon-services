package com.airbus.aerothon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.aerothon.dto.in.FlightQueryRequestDTO;
import com.airbus.aerothon.entities.impl.Airport;
import com.airbus.aerothon.entities.impl.Flight;
import com.airbus.aerothon.entities.impl.Program;
import com.airbus.aerothon.repository.FlightRepository;
import com.airbus.aerothon.repository.impl.AirportRepository;
import com.airbus.aerothon.repository.impl.ProgramRepository;
import com.google.common.collect.Lists;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ProgramRepository programRepository;
	
	@Autowired
	AirportRepository airportRepository;
	
	public List<Flight> getFlights(FlightQueryRequestDTO flightQueryRequestDTO) {
		return flightRepository.getFlights(flightQueryRequestDTO);
		//return Lists.newArrayList(flightRepository.findAll());
	}

	public Flight addFlight(Flight flight) {
		Program program = programRepository.findById(flight.getProgram().getId()).get();
		Airport source = airportRepository.findById(flight.getSourceAirport().getId()).get();
		Airport destination = airportRepository.findById(flight.getDestinationAirport().getId()).get();
		flight.setProgram(program);
		flight.setSourceAirport(source);
		flight.setDestinationAirport(destination);
		flightRepository.save(flight);
		return flight;
	}

	public Flight updateFlight(Integer flightId, Flight flight) {
		Program program = programRepository.findById(flight.getProgram().getId()).get();
		Airport source = airportRepository.findById(flight.getSourceAirport().getId()).get();
		Airport destination = airportRepository.findById(flight.getDestinationAirport().getId()).get();
		flight.setProgram(program);
		flight.setSourceAirport(source);
		flight.setDestinationAirport(destination);
		flightRepository.save(flight);
		return flight;
	}

	public Flight getFlight(Integer flightId) {
		return flightRepository.findById(flightId).get();
	}

	public Flight deleteFlight(Integer flightId) {
		Flight flight = flightRepository.findById(flightId).get();
		flightRepository.deleteById(flightId);
		return flight;
	}

}
