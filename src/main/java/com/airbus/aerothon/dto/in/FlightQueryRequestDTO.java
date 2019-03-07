package com.airbus.aerothon.dto.in;

import lombok.Data;

@Data
public class FlightQueryRequestDTO {

	Integer limit;
	Integer offset;
	String searchTerm;
	Integer sourceAirportId;
	Integer destinationAirportId;
}
