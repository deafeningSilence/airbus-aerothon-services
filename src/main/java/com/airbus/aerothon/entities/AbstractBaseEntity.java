package com.airbus.aerothon.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractBaseEntity {
	
	@Id
	@Column(name="id")
	private Integer id;
}
