package com.airbus.aerothon.dto.in;

import java.util.List;

public class FlightQueryRequestDTO {

	Integer limit;
	Integer offset;
	String searchTerm;
	List<String> searchVariables;
}
