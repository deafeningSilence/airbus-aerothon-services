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
@Table(name = "program")
public class Program extends AbstractBaseEntity{

	@Column(name="PROGRAM_NAME")
	private String programName;
	
}