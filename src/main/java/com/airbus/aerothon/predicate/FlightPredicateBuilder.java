package com.airbus.aerothon.predicate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.airbus.aerothon.constants.FlightSearchVariables;
import com.airbus.aerothon.dto.in.FlightQueryRequestDTO;

@Component
public class FlightPredicateBuilder {
	public List<Predicate> buildPredicates(FlightQueryRequestDTO flightQueryRequestDTO,
			CriteriaBuilder criteriaBuilder, Root<?> root) {
		List<Predicate> predicates = new ArrayList<>();
		if (flightQueryRequestDTO.getSearchTerm() != null) {
			Predicate searchPredicate = buildSearchPredicate(criteriaBuilder, flightQueryRequestDTO.getSearchTerm(), root);
			predicates.add(searchPredicate);
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
}
