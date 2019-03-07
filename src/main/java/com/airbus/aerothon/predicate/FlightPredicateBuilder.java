package com.airbus.aerothon.predicate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airbus.aerothon.constants.FlightSearchVariables;
import com.airbus.aerothon.dto.in.FlightQueryRequestDTO;
import com.airbus.aerothon.entities.impl.Airport;
import com.airbus.aerothon.repository.impl.AirportRepository;

@Component
public class FlightPredicateBuilder {

	@Autowired
	AirportRepository airportRepository;

	public List<Predicate> buildPredicates(FlightQueryRequestDTO flightQueryRequestDTO, CriteriaBuilder criteriaBuilder,
			Root<?> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (flightQueryRequestDTO.getSearchTerm() != null) {
			Predicate searchPredicate = buildSearchPredicate(criteriaBuilder, flightQueryRequestDTO.getSearchTerm(),
					root);
			predicates.add(searchPredicate);
		}
		if (flightQueryRequestDTO.getSourceAirportId() != null) {
			predicates.add(buildSourceAirportFilterPredicate(criteriaBuilder,
					flightQueryRequestDTO.getSourceAirportId(), root));
		}
		if (flightQueryRequestDTO.getDestinationAirportId() != null) {
			predicates.add(buildDestinationAirportFilterPredicate(criteriaBuilder,
					flightQueryRequestDTO.getDestinationAirportId(), root));
		}
		return predicates;
	}

	private Predicate buildSearchPredicate(CriteriaBuilder criteriaBuilder, String searchTerm, Root<?> root) {
		Predicate[] likePredicates = new Predicate[FlightSearchVariables.values().length];
		int i = 0;
		for (FlightSearchVariables field : FlightSearchVariables.values()) {
			likePredicates[i] = (criteriaBuilder.like(root.get(field.toString()).as(String.class),
					"%" + searchTerm + "%"));
			i++;
		}
		return criteriaBuilder.or(likePredicates);

	}

	private Predicate buildSourceAirportFilterPredicate(CriteriaBuilder criteriaBuilder, Integer sourceAirportId,
			Root<?> root) {
		Airport sourceAirport = airportRepository.findById(sourceAirportId).get();
		return criteriaBuilder.equal(root.get("sourceAirport").as(Airport.class), sourceAirport);
	}

	private Predicate buildDestinationAirportFilterPredicate(CriteriaBuilder criteriaBuilder,
			Integer destinationAirportId, Root<?> root) {
		Airport destinationAirport = airportRepository.findById(destinationAirportId).get();
		return criteriaBuilder.equal(root.get("destinationAirport").as(Airport.class), destinationAirport);
	}
}
