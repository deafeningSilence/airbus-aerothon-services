package com.airbus.aerothon.entities.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.airbus.aerothon.entities.AbstractBaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "test")
public class Test extends AbstractBaseEntity {

	@Column(name = "age")
	Integer age;

	@Column(name = "name")
	String name;

	@Column(name = "flightid")
	Integer flightId;

	@Column(name = "date")
	Date date;
}
