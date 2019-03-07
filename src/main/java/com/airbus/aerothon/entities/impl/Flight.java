package com.airbus.aerothon.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airbus.aerothon.entities.AbstractBaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "flight")
public class Flight extends AbstractBaseEntity{

	@Column(name = "MSN")
	private String msn;
	
	@Column(name = "HARNESS_LENGTH")
	private Integer harnessLength;
	
	@Column(name = "GROSS_WEIGHT")
	private Integer grossWeight;
	
	@Column(name = "ATM_P")
	private Integer atmP;
	
	@Column(name = "ROOM_TEMP")
	private Integer roomTemp;
	
	@Column(name = "AIRPORT")
	private String airport;
	
	@Column(name = "FCAP_LWING")
	private Integer fcapLwing;
	
	@Column(name = "FCAP_RWING")
	private Integer fcapRwing;
	
	@Column(name = "FQUANT_LWING")
	private Integer fquantLwing;
	
	@Column(name = "FQUANT_RWING")
	private Integer fquantRwing;
	
	@Column(name = "MAX_ALTITUDE")
	private Integer maxAltitude;
	
	@Column(name = "FLIGHT_NO")
	private String flightNo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "PROGRAM_ID")
	private Program program;
	
}
