package com.airbus.aerothon.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.aerothon.dto.in.FlightQueryRequestDTO;
import com.airbus.aerothon.entities.impl.Flight;
import com.airbus.aerothon.predicate.FlightPredicateBuilder;
import com.airbus.aerothon.repository.IFlightRepositoryCustom;

@Service
public class FlightRepositoryImpl implements IFlightRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private FlightPredicateBuilder flightPredicateBuilder;
	
	@Override
	public List<Flight> getFlights(FlightQueryRequestDTO flightQueryRequestDTO) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = (CriteriaQuery) criteriaBuilder.createQuery(Flight.class);
		Root root = (Root) criteriaQuery.from(Flight.class);
		List<Predicate> predicates = flightPredicateBuilder.buildPredicates(flightQueryRequestDTO, criteriaBuilder, root);
		CriteriaQuery selectQuery = criteriaQuery.select(root).distinct(true).where(predicates.toArray(new Predicate[] {}));
		TypedQuery typedQuery = em.createQuery(selectQuery);
		return typedQuery.getResultList();
	}

}
