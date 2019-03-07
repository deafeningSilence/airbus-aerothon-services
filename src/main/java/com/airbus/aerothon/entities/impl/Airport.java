package com.airbus.aerothon.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.airbus.aerothon.entities.AbstractBaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "airport")
public class Airport extends AbstractBaseEntity{

	@Column(name="AIRPORT_NAME")
	private String programName;
	
	@Column(name="AIRPORT_SYMBOL")
	private String airportSymbol;
	
}
