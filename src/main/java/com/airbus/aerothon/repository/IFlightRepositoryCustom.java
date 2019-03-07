package com.airbus.aerothon.repository;

import java.util.List;

import com.airbus.aerothon.dto.in.FlightQueryRequestDTO;
import com.airbus.aerothon.entities.impl.Flight;

public interface IFlightRepositoryCustom {
	
	List<Flight> getFlights(FlightQueryRequestDTO flightQueryRequestDTO);
}
